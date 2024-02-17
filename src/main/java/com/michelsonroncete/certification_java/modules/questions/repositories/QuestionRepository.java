package com.michelsonroncete.certification_java.modules.questions.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michelsonroncete.certification_java.modules.questions.entities.QuestionEntity;

public interface QuestionRepository extends JpaRepository<QuestionEntity, UUID>{

	List<QuestionEntity> findByTechnology(String technology);
}
