package org.managementsystem.model.course;

import java.util.Collections;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.managementsystem.IDao;
import org.managementsystem.model.HibernateUtil;

public class CourseDAOImpl implements IDao<Course> {
	Session session = null;

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> getDataList() {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(Course.class);
			List<Course> courseDataList = Collections.checkedList(
					criteria.list(), Course.class);
			return courseDataList;
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
	public void setData(Course t) {
		Course course = new Course(t.getSectionNo(), t.getCourseNo(),
				t.getCourseName());
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(course);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Database Error",
							"Veri Eklenirken Bir Sorun Oluþtu"));
			session.getTransaction().commit();
		} finally {
			session.close();
		}

	}

	@Override
	public void updateData(Course t) {
		// TODO Auto-generated method stub

	}

}
