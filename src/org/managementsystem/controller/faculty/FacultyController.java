package org.managementsystem.controller.faculty;

import java.util.List;

import org.managementsystem.IDao;
import org.managementsystem.model.faculty.Faculty;

public class FacultyController {
	private IDao<Faculty> dao;

	public FacultyController(IDao<Faculty> dao) {
		this.dao = dao;
	}

	public IDao<Faculty> getDao() {
		return dao;
	}

	public void setDao(IDao<Faculty> dao) {
		this.dao = dao;
	}

	public List<Faculty> getFacultyDataList() {
		return dao.getDataList();
	}

	public void setFacultyData(Faculty faculty) {
		dao.setData(faculty);
	}

	public void facultyUpdate(Faculty faculty) {
		dao.updateData(faculty);
	}
}
