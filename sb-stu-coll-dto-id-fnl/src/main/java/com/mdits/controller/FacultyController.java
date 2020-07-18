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

import com.mdits.model.Faculty;
import com.mdits.repository.FacultyRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(value = "FacultyRestController", 
description = "REST Apis related to Faculty Entity!!!!")
@RestController
@RequestMapping("/api")
public class FacultyController {
	
	@Autowired
	private FacultyRepository facultyRepository;
	
	
	@ApiOperation(value = "Get list of Faculty in the System ", 
			response = Iterable.class, tags = "getFaculties")
	@GetMapping(value = "/getAllFaculties")
	public List<Faculty> getAllFaculties(){
		
	return facultyRepository.findAll();
	}

	@ApiOperation(value = "Add Faculty in the System ", 
			response = Faculty.class, tags = "postFaculty")
	  @PostMapping("/faculty") 
	  public Faculty createFaculty(@RequestBody Faculty faculty) { 
		  return facultyRepository.save(faculty);
   }
	  
	@ApiOperation(value = "Update Faculty in the System ", 
			response = Faculty.class, tags = "putFaculty")
	  @PutMapping("/faculty/{facultyId}") 
	public Faculty updateFaculty(@PathVariable Integer facultyId,
	  @RequestBody Faculty faculty) { 
		return facultyRepository.saveAndFlush(faculty); }
	  
	
	@ApiOperation(value = "Delete Faculty in the System ", 
			response = Faculty.class, tags = "deleteFaculty")
	  @DeleteMapping("/faculty/{facultyId}") 
	public void deleteFaculty(@PathVariable Integer facultyId) {
	  facultyRepository.deleteById(facultyId); }
	 
	
}
