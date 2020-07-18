package com.mdits.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdits.dto.StudentDTO;
import com.mdits.model.AcademicDetails;
import com.mdits.model.Student;
import com.mdits.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private ConverterService converterService;
	
	public List<StudentDTO> getAllStudents(){
	List<Student> student = studentRepository.findAll();
	return student.stream().map(converterService::convertToDTO).collect(Collectors.toList());
	}
	
	 public StudentDTO getById(AcademicDetails studentId)
	 {
		 Student studentObject = studentRepository.findById(studentId).orElse(null);
		 return converterService.convertToDTO(studentObject);
	 }
	
}
