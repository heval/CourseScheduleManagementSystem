package org.managementsystem.model.user;

import java.util.Collections;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.managementsystem.IDao;
import org.managementsystem.model.HibernateUtil;

public class UserDAOImpl implements IDao<User> {
	Session session = null;

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getDataList() {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(User.class);
			List<User> userDataList = Collections.checkedList(criteria.list(),
					User.class);
			return userDataList;
		} catch (HibernateException e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Database Error",
							"Databasedeki Verilere Eriþilemiyor"));
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public void setData(User t) {
		User user = new User(t.getSectionNo(), t.getUserNo(), t.getUserMail(),
				t.getPassword());
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Database Error",
							"Veri Eklenirken Bir Sorun Oluþtu"));
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	@Override
	public void updateData(User t) {
		// TODO Auto-generated method stub

	}

}
