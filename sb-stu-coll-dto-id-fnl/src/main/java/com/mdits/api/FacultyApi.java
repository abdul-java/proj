package com.mdits.api;

import com.mdits.dto.FacultyDTO;
import com.mdits.model.Faculty;
import com.mdits.service.FacultyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Api(value = "FacultyRestController",
description = "REST Apis related to Faculty Entity!!!!")
@RestController
@RequestMapping("/api/v1")
public class FacultyApi {
	
	@Autowired
	private FacultyService facultyService;
	
	
	@ApiOperation(value = "Get list of Faculty in the System ",
			response = Iterable.class, tags = "getAllFaculties")
	@GetMapping(value = "/getAllFaculties")
	public List<FacultyDTO> getAllFacultysDetails(){
		
	return facultyService.getAllFacultys();
	}

	
	@ApiOperation(value = "get Faculty by Id in the System ",
			response = Faculty.class, tags = "getFacultybyId")
	  @GetMapping("/faculty/{facultyId}")
	public FacultyDTO getFacultyID(@PathVariable Integer facultyId) {
	  return facultyService.getFacultyById(facultyId); }
	 
	
}
