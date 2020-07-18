package com.mdits.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class College implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="collegeId", insertable = false, updatable = false, nullable = true)
	private int collegeId;
	private String collegeName;
	private String collegeCode;
	private String collegePhoneNumber;
	private String collegeAddress;
	private String collegeEmail;  
	
	 
	@OneToMany(fetch = FetchType.LAZY, targetEntity = Faculty.class, cascade = CascadeType.ALL)
	@JoinColumn(name =" faculty_Coll_Code", referencedColumnName = "collegeId") 
	private List<Faculty> faculties;
	 
}