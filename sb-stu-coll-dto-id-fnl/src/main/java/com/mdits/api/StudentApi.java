package com.mdits.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mdits.dto.StudentDTO;
import com.mdits.model.AcademicDetails;
import com.mdits.model.Student;
import com.mdits.service.StudentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "StudentRestController", 
description = "REST Apis related to Student Entity!!!!")
@RestController
@RequestMapping("/api/v1")
public class StudentApi {
	
	@Autowired
	private StudentService studentService;
	
	@ApiOperation(value = "Get list of Students in the System ", 
			response = Iterable.class, tags = "getStudents")
	@GetMapping("/students")
	public List<StudentDTO> getAllStudentDetails(){
	return studentService.getAllStudents();
	}
	
	@ApiOperation(value = "Get Student By Id in the System ", 
			response = Student.class, tags = "getStudentById")
	  @GetMapping("/student/{studentPhoneNumber}") 
	public StudentDTO getStudent(@PathVariable AcademicDetails studentId) {
	 return studentService.getById(studentId); }
	 
}

