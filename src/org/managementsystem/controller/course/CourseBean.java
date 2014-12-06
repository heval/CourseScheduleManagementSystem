package org.managementsystem.controller.course;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.managementsystem.controller.Updatable;
import org.managementsystem.model.course.Course;
import org.managementsystem.model.course.CourseDAOImpl;

@ManagedBean
@ViewScoped
public class CourseBean {
	CourseController controller = new CourseController(new CourseDAOImpl());
	List<Course> courseDataList = controller.getCourseDataList();
	private Course course = new Course();

	public Course getCourse() {
		return course;
	}

	public List<Course> getCourseDataList() {
		return courseDataList;
	}

	public void setCourseData() {
		controller.setCourseData(course);
		courseDataList.add(course);
		course = new Course();
	}

	public void courseUpdate() {
		Updatable.setUpdatable(false);
		controller.courseUpdate(course);
	}
}
