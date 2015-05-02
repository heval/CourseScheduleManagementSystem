package org.managementsystem.controller.course;

import org.managementsystem.controller.Updatable;
import org.managementsystem.model.course.Course;
import org.managementsystem.model.course.CourseDAOImpl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean
@ViewScoped
public class CourseBean {
	CourseController controller = new CourseController(new CourseDAOImpl());
	List<Course> courseDataList = controller.getCourseDataList();
	private Course course = new Course();

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course){
		this.course=course;
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

	public void courseDelete(){
		controller.courseDelete(course);
	}
}
