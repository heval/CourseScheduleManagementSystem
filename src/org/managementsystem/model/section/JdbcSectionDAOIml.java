package org.managementsystem.model.section;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.managementsystem.IDao;
import org.managementsystem.connection.ConnectionClass;

public class JdbcSectionDAOIml implements IDao<Section> {

	@Override
	public List<Section> getDataList() {
		ArrayList<Section> sectionDataList = new ArrayList<Section>();
		try (Connection con = ConnectionClass.getConnection();
				PreparedStatement ps = con
						.prepareStatement("select faculty_no,section_no,section_name"
								+ " from section")) {
			try (ResultSet result = ps.executeQuery()) {
				while (result.next()) {
					Section section = new Section();
					section.setFacultyNo(result.getInt(1));
					section.setSectionNo(result.getInt(2));
					section.setSectionName(result.getString(3));
					sectionDataList.add(section);
				}
			}
		} catch (SQLException e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Database Error",
							"Databasedeki Verilere eriþilemiyor"));
		}
		return sectionDataList;
	}

	@Override
	public void setData(Section section) {
		try (Connection con = ConnectionClass.getConnection();
				PreparedStatement ps = con
						.prepareStatement("insert into section"
								+ "(faculty_no,section_no,section_name) values"
								+ "(?,?,?)")) {

			ps.setInt(1, section.getFacultyNo());
			ps.setInt(2, section.getSectionNo());
			ps.setString(3, section.getSectionName());
			ps.executeUpdate();
		} catch (SQLException e) {
			FacesContext.getCurrentInstance().addMessage(
					null,

					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Database Error",
							"Veri Eklenirken Bir Sorun Oluþtu"));
		}

	}

	@Override
	public void updateData(Section section) {
		// TODO Auto-generated method stub

	}

}
