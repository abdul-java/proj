package com.mdits.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mdits.model.AcademicDetails;
import com.mdits.model.Student;
import com.mdits.repository.StudentRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "StudentRestController", 
description = "REST Apis related to Student Entity!!!!")
@RestController
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@ApiOperation(value = "Get list of Students in the System ", 
			response = Iterable.class, tags = "getStudents")
	@GetMapping("/students")
	public List<Student> getAllStudents(){
	return studentRepository.findAll();
	}
	
	@ApiOperation(value = "Add Student in the System ", 
			response = Student.class, tags = "postStudent")
	  @PostMapping("/students") 
	  public Student createStudent(@RequestBody Student student) { 
		  return studentRepository.save(student);
		  }
	  
	@ApiOperation(value = "Update Student-details in the System ", 
			response = Student.class, tags = "putStudent")
	  @PutMapping("/student/{studentId}")
	public Student updateStudent(@RequestBody Student student,
	  @PathVariable Integer studentId) { 
		return studentRepository.saveAndFlush(student); 
		}
	  
	@ApiOperation(value = "Delete Students in the System ", 
			response = Student.class, tags = "deleteStudent")
	  @DeleteMapping("/student/{studentId}") 
	public void deleteStudent(@PathVariable AcademicDetails studentId) {
	  studentRepository.deleteById(studentId); }
	 
	
}

