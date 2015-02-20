package org.managementsystem.controller.user;

import org.managementsystem.model.user.User;
import org.managementsystem.model.user.UserDAOImpl;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;


@ManagedBean
public class LoginBean {
	UserController controller = new UserController(new UserDAOImpl());
	List<User> userInfoList = controller.getUserDataList();
	private User user = new User();
	public User getUser() {
		return user;
	}

	public void loginControl() throws ServletException, IOException {
		String userName = getUser().getUserMail();
		String userPassword = getUser().getPassword();
		for (int i = 0; i < userInfoList.size(); i++) {
			user = userInfoList.get(i);
			if (user.getUserMail().equals(userName)
					&& user.getPassword().equals(userPassword)) {
				FacesContext.getCurrentInstance().getExternalContext()
						.getSessionMap().put("user", userName);
				sending();
				break;
			}
		}
	}
	public String logoutControl() {
		FacesContext.getCurrentInstance().getExternalContext()
				.invalidateSession();
		return "login.jsf";
	}

	public String sending() {
		if (FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().get("user") != null) {
			return "index?faces-redirect=true";
		} else {
			FacesContext.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR,
									"Could not login",
									"Mail Adresi veya Şifre Hatalı"));
			return "";
		}
	}
}