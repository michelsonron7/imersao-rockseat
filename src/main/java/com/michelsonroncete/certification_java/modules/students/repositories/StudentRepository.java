package com.michelsonroncete.certification_java.modules.students.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michelsonroncete.certification_java.entities.StudentsEntity;

public interface StudentRepository extends JpaRepository<StudentsEntity, UUID>{

	public Optional<StudentsEntity> findByEmail(String email);
	
	
}
