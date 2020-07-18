package com.mdits.service;

import com.mdits.dto.FacultyDTO;
import com.mdits.model.Faculty;
import com.mdits.repository.FacultyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor

@Service
public class FacultyService {

	@Autowired
	private FacultyRepository facultyRepository;
	
	@Autowired
	private ConverterService converterService;
	
	public List<FacultyDTO> getAllFacultys(){
		
	List<Faculty> faculty = facultyRepository.findAll();
	return faculty.stream().map(converterService::convertToDTO).collect(Collectors.toList());
	}
	
	 public FacultyDTO getFacultyById(int facultyId)
	 {
		 Faculty facultyObject = facultyRepository.findById(facultyId).orElse(null);
		 return converterService.convertToDTO(facultyObject);
	 }
	
}
