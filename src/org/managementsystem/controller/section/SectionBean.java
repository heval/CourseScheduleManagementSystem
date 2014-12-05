package org.managementsystem.controller.section;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.managementsystem.controller.Updatable;
import org.managementsystem.model.section.Section;
import org.managementsystem.model.section.SectionDAOImpl;

@ManagedBean
@ViewScoped
public class SectionBean {
	SectionController controller = new SectionController(new SectionDAOImpl());
	List<Section> sectionDataList = controller.getSectionDataList();
	private Section section = new Section();

	public Section getSection() {
		return section;
	}

	public List<Section> getSectionDataList() {
		return sectionDataList;
	}

	public void setSectionData() {
		controller.setSectionData(section);
		sectionDataList.add(section);
		section = new Section();
	}

	public void sectionUpdate() {
		Updatable.setUpdatable(false);
		controller.sectionUpdate(section);
	}
}
