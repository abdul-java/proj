package com.mdits.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

@Embeddable
public class AcademicDetails implements Serializable {
  
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@Length(min = 1, max = 3)
	private String yearOfAdmission ;
	
	@NotNull
	@Length(min = 1, max = 3)
	private String college_Code;
	
	@NotNull
	@Length(min = 1, max = 3)
	private String collegeZone;
	
	@NotNull
	@Length(min = 1, max = 3)
	private String deptCode;
	
	  @NotNull
	  @Length(min = 1, max = 3)
	  private String StudentId;
	 
    public AcademicDetails() {
    }

	public AcademicDetails(@NotNull @Length(min = 1, max = 3) String yearOfAdmission,
			@NotNull @Length(min = 1, max = 3) String college_Code,
			@NotNull @Length(min = 1, max = 3) String collegeZone, @NotNull @Length(min = 1, max = 3) String deptCode,
			@NotNull @Length(min = 1, max = 3) String studentId) {
		super();
		this.yearOfAdmission = yearOfAdmission;
		this.college_Code = college_Code;
		this.collegeZone = collegeZone;
		this.deptCode = deptCode;
		StudentId = studentId;
	}



	public void setYearOfAdmission(String yearOfAdmission) {
		this.yearOfAdmission = yearOfAdmission;
	}


	public void setCollege_Code(String college_Code) {
		this.college_Code = college_Code;
	}


	public void setcollegeZone(String collegeZone) {
		this.collegeZone = collegeZone;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getStudentId() {
		return yearOfAdmission + college_Code + collegeZone + deptCode +StudentId;
	}

	
	public void setStudentId(String studentId) {
		StudentId = studentId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((StudentId == null) ? 0 : StudentId.hashCode());
		result = prime * result + ((college_Code == null) ? 0 : college_Code.hashCode());
		result = prime * result + ((deptCode == null) ? 0 : deptCode.hashCode());
		result = prime * result + ((yearOfAdmission == null) ? 0 : yearOfAdmission.hashCode());
		result = prime * result + ((collegeZone == null) ? 0 : collegeZone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AcademicDetails other = (AcademicDetails) obj;
		if (StudentId == null) {
			if (other.StudentId != null)
				return false;
		} else if (!StudentId.equals(other.StudentId))
			return false;
		if (college_Code == null) {
			if (other.college_Code != null)
				return false;
		} else if (!college_Code.equals(other.college_Code))
			return false;
		if (deptCode == null) {
			if (other.deptCode != null)
				return false;
		} else if (!deptCode.equals(other.deptCode))
			return false;
		if (yearOfAdmission == null) {
			if (other.yearOfAdmission != null)
				return false;
		} else if (!yearOfAdmission.equals(other.yearOfAdmission))
			return false;
		if (collegeZone == null) {
			if (other.collegeZone != null)
				return false;
		} else if (!collegeZone.equals(other.collegeZone))
			return false;
		return true;
	}

	
}
