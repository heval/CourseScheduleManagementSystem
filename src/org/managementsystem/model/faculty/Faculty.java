package org.managementsystem.model.faculty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Faculty {

	private Integer facultyNo;
	private String facultyName;

	public Faculty() {

	}

	public Faculty(Integer facultyNo, String facultyName) {
		this.facultyNo = facultyNo;
		this.facultyName = facultyName;
	}

	@Id
	@Column(name = "faculty_no")
	public Integer getFacultyNo() {
		return facultyNo;
	}

	public void setFacultyNo(Integer facultyNo) {
		this.facultyNo = facultyNo;
	}

	@Column(name = "faculty_name", nullable = false)
	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
}
