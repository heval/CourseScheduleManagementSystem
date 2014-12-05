package org.managementsystem.controller.faculty;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.managementsystem.controller.Updatable;
import org.managementsystem.model.faculty.Faculty;
import org.managementsystem.model.faculty.FacultyDAOImpl;

@ManagedBean
@ViewScoped
public class FacultyBean {
	private FacultyController controller = new FacultyController(
			new FacultyDAOImpl());
	private List<Faculty> facultyDataList = controller.getFacultyDataList();
	private Faculty faculty = new Faculty();

	public Faculty getFaculty() {
		return faculty;
	}

	public List<Faculty> getFacultyDataList() {
		return facultyDataList;
	}

	public void setFacultyData() {
		controller.setFacultyData(faculty);
		facultyDataList.add(faculty);
		faculty = new Faculty();
	}

	public void facultyUpdate() {
		Updatable.setUpdatable(false);
		controller.facultyUpdate(faculty);
	}
}
