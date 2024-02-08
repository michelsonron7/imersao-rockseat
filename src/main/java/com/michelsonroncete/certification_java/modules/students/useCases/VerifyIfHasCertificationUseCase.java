package com.michelsonroncete.certification_java.modules.students.useCases;

import org.springframework.stereotype.Service;

import com.michelsonroncete.certification_java.modules.students.dto.VerifyHasCertificationDTO;

@Service
public class VerifyIfHasCertificationUseCase {

	public boolean execute(VerifyHasCertificationDTO dto) {
		if(dto.getEmail().equals("michelsonroncete@gmail.com") && dto.getTechnology().equals("JAVA")) {
			return true;
		}
		return false;
	}
}
