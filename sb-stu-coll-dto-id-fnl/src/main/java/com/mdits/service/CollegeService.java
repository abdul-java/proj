package com.mdits.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdits.dto.CollegeDTO;
import com.mdits.model.College;
import com.mdits.repository.CollegeRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@Service
public class CollegeService {

	@Autowired
	private CollegeRepository collegeRepository;
	
	@Autowired
	private ConverterService converterService;
	
	public List<CollegeDTO> getAllColleges(){
		
	List<College> college = collegeRepository.findAll();
	return college.stream().map(converterService::convertToDTO).collect(Collectors.toList());
	}
	
	 public CollegeDTO getCollegeById(int collegeId)
	 {
		 College collegeObject = collegeRepository.findById(collegeId).orElse(null);
		 return converterService.convertToDTO(collegeObject);
	 }
	
}
