package org.managementsystem.model.faculty;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.managementsystem.IDao;
import org.managementsystem.model.HibernateUtil;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.Collections;
import java.util.List;

public class FacultyDAOImpl implements IDao<Faculty> {
	Session session = null;

	@SuppressWarnings("unchecked")
	@Override
	public List<Faculty> getDataList() {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(Faculty.class);
			List<Faculty> facultyDataList = Collections.checkedList(
					criteria.list(), Faculty.class);
			return facultyDataList;
		} catch (HibernateException e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Database Error",
							"Databasedeki Verilere Erişilemiyor"));
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public void setData(Faculty t) {
		Faculty faculty = new Faculty(t.getFacultyNo(), t.getFacultyName());
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(faculty);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Database Error",
							"Veri Eklenirken Bir Sorun Oluştu"));
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	@Override
	public void updateData(Faculty t) {
		Faculty faculty = new Faculty(t.getFacultyNo(), t.getFacultyName());
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(faculty);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Database Error",
							"Veri Güncellenirken Bir Sorun Oluştu"));
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteData(Faculty t) {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(t);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Database Error",
							"Veri G�ncellenirken Bir Sorun Olu�tu"));
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}
}
