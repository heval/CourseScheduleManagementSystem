package org.managementsystem.controller.section;

import java.util.List;

import org.managementsystem.IDao;
import org.managementsystem.model.section.Section;

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

}
