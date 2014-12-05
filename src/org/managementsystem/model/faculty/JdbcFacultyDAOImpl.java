package org.managementsystem.model.faculty;

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

public class JdbcFacultyDAOImpl implements IDao<Faculty> {

	@Override
	public List<Faculty> getDataList() {
		ArrayList<Faculty> facultyDataList = new ArrayList<Faculty>();
		try (Connection con = ConnectionClass.getConnection();
				PreparedStatement ps = con
						.prepareStatement("select faculty_no,faculty_name"
								+ " from faculty")) {
			try (ResultSet result = ps.executeQuery()) {
				while (result.next()) {
					Faculty faculty = new Faculty();
					faculty.setFacultyNo(result.getInt(1));
					faculty.setFacultyName(result.getString(2));
					facultyDataList.add(faculty);
				}
			}
		} catch (SQLException e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Database Error",
							"Databasedeki Verilere eriþilemiyor"));
		}
		return facultyDataList;
	}

	@Override
	public void setData(Faculty faculty) {
		try (Connection con = ConnectionClass.getConnection();
				PreparedStatement ps = con
						.prepareStatement("insert into faculty"
								+ "(faculty_no,faculty_name) values" + "(?,?)")) {
			ps.setInt(1, faculty.getFacultyNo());
			ps.setString(2, faculty.getFacultyName());
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
	public void updateData(Faculty faculty) {
		// TODO Auto-generated method stub

	}

}
