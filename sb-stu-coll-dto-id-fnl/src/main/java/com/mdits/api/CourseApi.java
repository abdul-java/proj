package com.mdits.api;

import com.mdits.dto.CourseDTO;
import com.mdits.model.Course;
import com.mdits.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Api(value = "CourseRestController",
description = "REST Apis related to Course Entity!!!!")
@RestController
@RequestMapping("/api/v1")
public class CourseApi {
	
	@Autowired
	private CourseService courseService;
	
	
	@ApiOperation(value = "Get list of Course in the System ",
			response = Iterable.class, tags = "getAllCourses")
	@GetMapping(value = "/getAllCourses")
	public List<CourseDTO> getAllCoursesDetails(){
		
	return courseService.getAllCourses();
	}

	
	@ApiOperation(value = "get Course by Id in the System ",
			response = Course.class, tags = "getCoursebyId")
	  @GetMapping("/course/{courseId}")
	public CourseDTO getCourseID(@PathVariable Integer courseId) {
	  return courseService.getCourseById(courseId); }
	 
	
}
