package com.mdits.dto;

import com.mdits.model.AcademicDetails;

import lombok.Data;

@Data
public class StudentDTO {

	private AcademicDetails studentId;
	private String studentName;
	private long studentPhoneNumber;
}
