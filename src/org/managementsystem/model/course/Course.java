package org.managementsystem.model.course;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Course {
	private Integer sectionNo;
	private Integer courseNo;
	private String courseName;

	public Course() {

	}

	public Course(Integer sectionNo, Integer courseNo, String courseName) {
		this.sectionNo = sectionNo;
		this.courseNo = courseNo;
		this.courseName = courseName;
	}

	@Column(name = "section_no", nullable = false)
	public Integer getSectionNo() {
		return sectionNo;
	}

	public void setSectionNo(Integer sectionNo) {
		this.sectionNo = sectionNo;
	}

	@Id
	@Column(name = "course_no")
	public Integer getCourseNo() {
		return courseNo;
	}

	public void setCourseNo(Integer courseNo) {
		this.courseNo = courseNo;
	}

	@Column(name = "course_name")
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
}
