package com.michelsonroncete.certification_java.modules.questions.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.michelsonroncete.certification_java.modules.questions.dto.AlternativesResultDTO;
import com.michelsonroncete.certification_java.modules.questions.dto.QuestionResultDTO;
import com.michelsonroncete.certification_java.modules.questions.entities.AlternativesEntity;
import com.michelsonroncete.certification_java.modules.questions.entities.QuestionEntity;
import com.michelsonroncete.certification_java.modules.questions.repositories.QuestionRepository;

@RestController
@RequestMapping("/questions")
public class QuestionController {
	
	@Autowired
	private QuestionRepository questionRepository;

	@GetMapping("/technology/{technology}")
	public List<QuestionResultDTO> findByTechnology(@PathVariable String technology){
		System.out.println("TECH ===" + technology);
		var result = this.questionRepository.findByTechnology(technology);
		
		var toMap = result.stream().map(question -> mapQuestionToDto(question))
		.collect(Collectors.toList());
		return toMap;
	}
	
	static QuestionResultDTO mapQuestionToDto(QuestionEntity question) {
		var questionResultDto = QuestionResultDTO.builder()
				.id(question.getId())
				.technology(question.getTechnology())
				.description(question.getDescription()).build();
		
		List<AlternativesResultDTO> alternativesResultDtos = question.getAlternatives()
				.stream().map(alternative -> mapAlternativeDto(alternative))
				.collector(Collectors.toList());
		
		questionResultDto.setAlternatives(alternativesResultDtos);
		return questionResultDto;
	}
	
	static AlternativesResultDTO mapAlternativesDto(AlternativesEntity alternativesResultDto) {
		return AlternativesResultDTO.builder()
				.id(alternativesResultDto.getId())
				.description(alternativesResultDto.getDescription()).build();
	}
}