package com.mdits.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mdits.model.College;

public interface CollegeRepository extends JpaRepository<College,Integer> {

  
}
