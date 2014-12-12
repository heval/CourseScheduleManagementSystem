package org.managementsystem.controller.courseschedule;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.managementsystem.controller.course.CourseBean;
import org.managementsystem.model.course.Course;
import org.primefaces.event.DragDropEvent;

@ManagedBean(name = "dragDrop")
@ApplicationScoped
public class CourseScheduleDragDrop {
	private List<Course> courseDataList = new CourseBean().getCourseDataList();
	private List<Course> courseScheduleDataList = new ArrayList<Course>();

	public void onCourseDrop(DragDropEvent e) {
		Course course = (Course) e.getData();
		courseScheduleDataList.add(course);
		courseDataList.remove(course);
	}

	public List<Course> getCourseDataList() {
		return courseDataList;
	}

	public List<Course> getCourseScheduleDataList() {
		return courseScheduleDataList;
	}

}
