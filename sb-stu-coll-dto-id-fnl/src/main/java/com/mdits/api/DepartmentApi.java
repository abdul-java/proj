package com.mdits.api;

import com.mdits.dto.DepartmentDTO;
import com.mdits.model.Department;
import com.mdits.service.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Api(value = "DepartmentRestController",
description = "REST Apis related to Department Entity!!!!")
@RestController
@RequestMapping("/api/v1")
public class DepartmentApi {
	
	@Autowired
	private DepartmentService departmentService;
	
	
	@ApiOperation(value = "Get list of Department in the System ",
			response = Iterable.class, tags = "getAllDepartments")
	@GetMapping(value = "/getAllDepartments")
	public List<DepartmentDTO> getAllDepartmentsDetails(){
		
	return departmentService.getAllDepartments();
	}

	
	@ApiOperation(value = "get DepartmentById in the System ",
			response = Department.class, tags = "getDepartmentById")
	  @GetMapping("/department/{departmentId}")
	public DepartmentDTO getDepartmentID(@PathVariable Integer departmentId) {
	  return departmentService.getDepartmentById(departmentId); }
	 
	
}
