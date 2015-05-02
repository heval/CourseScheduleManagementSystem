package org.managementsystem.controller.user;

import org.managementsystem.controller.Updatable;
import org.managementsystem.model.user.User;
import org.managementsystem.model.user.UserDAOImpl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean
@ViewScoped
public class UserBean {
	UserController controller = new UserController(new UserDAOImpl());
	List<User> userDataList = controller.getUserDataList();
	private User user = new User();

	public User getUser() {
		return user;
	}

	public void setUser(User user){
		this.user=user;
	}

	public List<User> getUserDataList() {
		return userDataList;
	}

	public void setUserData() {
		controller.setUserData(user);
		userDataList.add(user);
		user = new User();
	}

	public void userUpdate() {
		Updatable.setUpdatable(false);
		controller.userUpdate(user);
	}
	public void userDelete(){
		controller.userDelete(user);
	}
}
