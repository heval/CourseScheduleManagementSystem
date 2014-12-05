package org.managementsystem.model.user;

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

public class JdbcUserDAOImpl implements IDao<User> {

	@Override
	public List<User> getDataList() {
		ArrayList<User> userDataList = new ArrayList<User>();
		try (Connection con = ConnectionClass.getConnection();
				PreparedStatement ps = con
						.prepareStatement("select section_no,user_no,user_name,password"
								+ " from user")) {
			try (ResultSet result = ps.executeQuery()) {

				while (result.next()) {
					User user = new User();
					user.setSectionNo(result.getInt(1));
					user.setUserNo(result.getInt(2));
					user.setUserMail(result.getString(3));
					user.setPassword(result.getString(4));
					userDataList.add(user);
				}
			}
		} catch (SQLException e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Database Error",
							"Databasedeki Verilere eriþilemiyor"));
		}
		return userDataList;
	}

	@Override
	public void setData(User user) {
		try (Connection con = ConnectionClass.getConnection();
				PreparedStatement ps = con.prepareStatement("insert into user"
						+ "(section_no,user_no,user_name,password)"
						+ " values(?,?,?,?)")) {
			ps.setInt(1, user.getSectionNo());
			ps.setInt(2, user.getUserNo());
			ps.setString(3, user.getUserMail());
			ps.setString(4, user.getPassword());
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
	public void updateData(User t) {
		// TODO Auto-generated method stub

	}

}
