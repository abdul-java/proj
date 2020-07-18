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

import com.mdits.model.Department;
import com.mdits.repository.DepartmentRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(value = "DepartmentRestController", 
description = "REST Apis related to Department Entity!!!!")
@RestController
@RequestMapping("/api")
public class DepartmentController {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	
	@ApiOperation(value = "Get list of Department in the System ", 
			response = Iterable.class, tags = "getDepartments")
	@GetMapping(value = "/getAllDepartments")
	public List<Department> getAllDepartments(){
		
	return departmentRepository.findAll();
	}

	@ApiOperation(value = "Add Department in the System ", 
			response = Department.class, tags = "postDepartment")
	  @PostMapping("/departments") 
	  public Department createDepartment(@RequestBody Department department) { 
		  return departmentRepository.save(department);
   }
	  
	@ApiOperation(value = "Update Department in the System ", 
			response = Department.class, tags = "putDepartment")
	  @PutMapping("/department/{departmentId}") 
	public Department updateDepartment(@PathVariable Integer departmentId,
	  @RequestBody Department department) { 
		return departmentRepository.saveAndFlush(department); }
	  
	
	@ApiOperation(value = "Delete Department in the System ", 
			response = Department.class, tags = "deleteDepartment")
	  @DeleteMapping("/department/{departmentId}") 
	public void deleteDepartment(@PathVariable Integer departmentId) {
	  departmentRepository.deleteById(departmentId); }
	 
	
}
