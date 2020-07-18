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

import com.mdits.model.Course;
import com.mdits.repository.CourseRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(value = "CourseRestController", 
description = "REST Apis related to Course Entity!!!!")
@RestController
@RequestMapping("/api")
public class CourseController {
	
	@Autowired
	private CourseRepository courseRepository;
	
	
	@ApiOperation(value = "Get list of Course in the System ", 
			response = Iterable.class, tags = "getCourses")
	@GetMapping(value = "/getAllCourses")
	public List<Course> getAllCourses(){
		
	return courseRepository.findAll();
	}

	@ApiOperation(value = "Add Course in the System ", 
			response = Course.class, tags = "postCourse")
	  @PostMapping("/courses") 
	  public Course createCourse(@RequestBody Course course) { 
		  return courseRepository.save(course);
   }
	  
	@ApiOperation(value = "Update Course in the System ", 
			response = Course.class, tags = "putCourse")
	  @PutMapping("/course/{courseId}") 
	public Course updateCourse(@PathVariable Integer courseId,
	  @RequestBody Course course) { 
		return courseRepository.saveAndFlush(course); }
	  
	
	@ApiOperation(value = "Delete Course in the System ", 
			response = Course.class, tags = "deleteCourse")
	  @DeleteMapping("/course/{courseId}") 
	public void deleteCourse(@PathVariable Integer courseId) {
	  courseRepository.deleteById(courseId);
	  }
	 
	
}
