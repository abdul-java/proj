package com.mdits.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mdits.dto.CollegeDTO;
import com.mdits.model.College;
import com.mdits.service.CollegeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(value = "CollegeRestController", 
description = "REST Apis related to College Entity!!!!")
@RestController
@RequestMapping("/api/v1")
public class CollegeApi {
	
	@Autowired
	private CollegeService collegeService;
	
	
	@ApiOperation(value = "Get list of College in the System ", 
			response = Iterable.class, tags = "getAllColleges")
	@GetMapping(value = "/getAllColleges")
	public List<CollegeDTO> getAllCollegesDetails(){
		
	return collegeService.getAllColleges();
	}

	
	@ApiOperation(value = "get College by Id in the System ", 
			response = College.class, tags = "getCollegebyId")
	  @GetMapping("/college/{collegeId}") 
	public CollegeDTO getCollegeID(@PathVariable Integer collegeId) {
	  return collegeService.getCollegeById(collegeId); }
	 
	
}
