package org.managementsystem.controller.section;

import org.managementsystem.dao.IDao;
import org.managementsystem.model.section.Section;

import java.util.List;

public class SectionController {
	private IDao<Section> dao;

	public SectionController(IDao<Section> dao) {
		this.dao = dao;
	}

	public IDao<Section> getDao() {
		return dao;
	}

	public void setDao(IDao<Section> dao) {
		this.dao = dao;
	}

	public List<Section> getSectionDataList() {
		return dao.getDataList();
	}

	public void setSectionData(Section section) {
		dao.setData(section);
	}

	public void sectionUpdate(Section section) {
		dao.updateData(section);
	}

	public void sectionDelete(Section section) {
		dao.deleteData(section);
	}
}
