package com.mdits.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Entity;
import lombok.Data;

@Data
@Entity
@AttributeOverrides({  
    @AttributeOverride(name="courseId", column = @javax.persistence.Column(name="courseId")),  
    @AttributeOverride(name="courseName", column = @javax.persistence.Column(name="courseName"))  
})  
public class Faculty extends Course implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private int facultyId;
	private String facultyName;
	private int faculty_Coll_Code;
	
}
