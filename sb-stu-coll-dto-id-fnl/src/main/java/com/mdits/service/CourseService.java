package com.mdits.service;

import com.mdits.dto.CourseDTO;
import com.mdits.model.Course;
import com.mdits.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private ConverterService converterService;
	
	public List<CourseDTO> getAllCourses(){
		
	List<Course> Course = courseRepository.findAll();
	return Course.stream().map(converterService::convertToDTO).collect(Collectors.toList());
	}
	
	 public CourseDTO getCourseById(int courseId)
	 {
		 Course courseObject = courseRepository.findById(courseId).orElse(null);
		 return converterService.convertToDTO(courseObject);
	 }
	
}
