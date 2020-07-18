package com.mdits.service;

import com.mdits.dto.DepartmentDTO;
import com.mdits.model.Department;
import com.mdits.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private ConverterService converterService;
	
	public List<DepartmentDTO> getAllDepartments(){
		
	List<Department> department = departmentRepository.findAll();
	return department.stream().map(converterService::convertToDTO).collect(Collectors.toList());
	}
	
	 public DepartmentDTO getDepartmentById(int departmentId)
	 {
		 Department departmentObject = departmentRepository.findById(departmentId).orElse(null);
		 return converterService.convertToDTO(departmentObject);
	 }
	
}
