package com.mdits.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mdits.model.Course;

public interface CourseRepository extends JpaRepository<Course,Integer> {

  
}
