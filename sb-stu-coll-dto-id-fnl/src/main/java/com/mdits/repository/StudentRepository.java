package com.mdits.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mdits.model.AcademicDetails;
import com.mdits.model.Student;

public interface StudentRepository extends JpaRepository<Student, AcademicDetails> {

}
