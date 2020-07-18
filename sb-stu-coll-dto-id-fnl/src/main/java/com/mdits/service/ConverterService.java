package com.mdits.service;


import com.mdits.dto.*;
import com.mdits.model.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ConverterService {

	@Autowired
	private ModelMapper modelMapper;
	
	public CollegeDTO convertToDTO(College collegeObject)
	{
		return modelMapper.map(collegeObject, CollegeDTO.class);
	}

	public StudentDTO convertToDTO(Student studentObject)
	{
		return modelMapper.map(studentObject, StudentDTO.class);
	}

	public CourseDTO convertToDTO(Course courseObject)
	{
		return modelMapper.map(courseObject, CourseDTO.class);
	}

	public DepartmentDTO convertToDTO(Department departmentObject)
	{
		return modelMapper.map(departmentObject, DepartmentDTO.class);
	}

	public FacultyDTO convertToDTO(Faculty facultyObject)
	{
		return modelMapper.map(facultyObject, FacultyDTO.class);
	}

}
