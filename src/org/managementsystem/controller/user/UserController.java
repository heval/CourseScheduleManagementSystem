package org.managementsystem.controller.user;

import org.managementsystem.dao.IDao;
import org.managementsystem.model.user.User;

import java.util.List;

public class UserController {
	private IDao<User> dao;

	public UserController(IDao<User> dao) {
		this.dao = dao;
	}

	public IDao<User> getDao() {
		return dao;
	}

	public void setDao(IDao<User> dao) {
		this.dao = dao;
	}

	public List<User> getUserDataList() {
		return dao.getDataList();
	}

	public void setUserData(User user) {
		dao.setData(user);
	}

	public void userUpdate(User user) {
		dao.updateData(user);
	}

	public void userDelete(User user){
		dao.deleteData(user);
	}
}
