package com.mdits.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mdits.model.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty,Integer> {

  
}
