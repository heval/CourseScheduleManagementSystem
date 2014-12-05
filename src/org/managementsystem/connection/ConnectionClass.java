package org.managementsystem.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class ConnectionClass {
	private static Connection con;
	private static final String username = "root";
	private static final String password = "120014250";
	private static final String url = "jdbc:mysql://localhost:3306/managementsystem?useUnicode=true&characterEncoding=UTF-8";

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Database Error",
							"Database bağlantısı gerçekleştirilemedi"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}
}
