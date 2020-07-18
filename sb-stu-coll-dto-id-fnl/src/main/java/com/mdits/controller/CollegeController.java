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

import com.mdits.model.College;
import com.mdits.repository.CollegeRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(value = "CollegeRestController", 
description = "REST Apis related to College Entity!!!!")
@RestController
@RequestMapping("/api")
public class CollegeController {
	
	@Autowired
	private CollegeRepository collegeRepository;
	
	
	@ApiOperation(value = "Get list of College in the System ", 
			response = Iterable.class, tags = "getColleges")
	@GetMapping(value = "/getAllColleges")
	public List<College> getAllColleges(){
		
	return collegeRepository.findAll();
	}

	@ApiOperation(value = "Add College in the System ", 
			response = College.class, tags = "postCollege")
	  @PostMapping("/colleges") 
	  public College createCollege(@RequestBody College college) { 
		  return collegeRepository.save(college);
   }
	  
	@ApiOperation(value = "Update College in the System ", 
			response = College.class, tags = "putCollege")
	  @PutMapping("/college/{collegeId}") 
	public College updateCollege(@PathVariable Integer collegeId,
	  @RequestBody College college) { 
		return collegeRepository.saveAndFlush(college); }
	  
	
	@ApiOperation(value = "Delete College in the System ", 
			response = College.class, tags = "deleteCollege")
	  @DeleteMapping("/college/{collegeId}") 
	public void deleteCollege(@PathVariable Integer collegeId) {
	  collegeRepository.deleteById(collegeId); }
	 
	
}
