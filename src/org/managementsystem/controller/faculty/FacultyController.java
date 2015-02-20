package org.managementsystem.controller.faculty;

import org.managementsystem.IDao;
import org.managementsystem.model.faculty.Faculty;

import java.util.List;

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

	public void facultyDelete(Faculty faculty) {
		dao.deleteData(faculty);
	}
}
