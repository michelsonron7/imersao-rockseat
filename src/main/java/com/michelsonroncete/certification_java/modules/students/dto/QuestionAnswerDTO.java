package com.michelsonroncete.certification_java.modules.students.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionAnswerDTO {

	private String questionID;
	private String alternativeID;
	private boolean isCorrect;
}
