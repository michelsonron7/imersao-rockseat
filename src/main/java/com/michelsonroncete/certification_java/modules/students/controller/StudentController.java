package com.michelsonroncete.certification_java.modules.students.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.michelsonroncete.certification_java.modules.students.dto.VerifyHasCertificationDTO;
import com.michelsonroncete.certification_java.modules.students.useCases.VerifyIfHasCertificationUseCase;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private VerifyIfHasCertificationUseCase verifyIfHasCertificationUseCase;

	@PostMapping("/verifyIfHasCertification")
	public String verifyIfString(@RequestBody VerifyHasCertificationDTO verifyHasCertificationDTO){
		
		var result = this.verifyIfHasCertificationUseCase.execute(verifyHasCertificationDTO);
		if (result) {
			return "Usuário já fez a prova";
		}
		return"Usuário pode fazer a prova";
	}
	
}
