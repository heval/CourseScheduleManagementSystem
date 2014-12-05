package org.managementsystem.model.section;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Section {

	private Integer facultyNo;
	private Integer sectionNo;
	private String sectionName;

	public Section() {

	}

	public Section(Integer facultyNo, Integer sectionNo, String sectionName) {
		this.facultyNo = facultyNo;
		this.sectionNo = sectionNo;
		this.sectionName = sectionName;
	}

	@Column(name = "faculty_no")
	public Integer getFacultyNo() {
		return facultyNo;
	}

	public void setFacultyNo(Integer facultyNo) {
		this.facultyNo = facultyNo;
	}

	@Id
	@Column(name = "section_no", nullable = false)
	public Integer getSectionNo() {
		return sectionNo;
	}

	public void setSectionNo(Integer sectionNo) {
		this.sectionNo = sectionNo;
	}

	@Column(name = "section_name", nullable = false)
	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
}
