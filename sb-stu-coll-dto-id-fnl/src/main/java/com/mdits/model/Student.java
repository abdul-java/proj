package com.mdits.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId 
	private AcademicDetails studentId;
	private String studentName;
	private String studentPhoneNumber;
	private String studentEmail;
	private String studentAddress;
	private int stu_Coll_Id;
	private int stu_Dept_Code;
	private int stu_Course_Id;
	
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "stu_Dept_Code", referencedColumnName =
	  "departmentCode", insertable = false, updatable = false) 
	  private Department Departments;
 
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "stu_Coll_Id", referencedColumnName =
	  "collegeId", insertable = false, updatable = false) 
	  private College College;
		 
	@OneToMany
	@JoinColumn(name =" courseCode", referencedColumnName = "stu_Course_Id") 
	private List<Course> courses;
	
	
}

