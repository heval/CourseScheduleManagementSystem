package org.managementsystem.model.course;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.managementsystem.IDao;
import org.managementsystem.model.HibernateUtil;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.Collections;
import java.util.List;

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
							"Databasedeki Verilere Eri�ilemiyor"));
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
							"Veri Eklenirken Bir Sorun Olu�tu"));
			session.getTransaction().commit();
		} finally {
			session.close();
		}

	}

	@Override
	public void updateData(Course t) {
		Course course=new Course(t.getSectionNo(),t.getCourseNo(),t.getCourseName());
		try{
			session= HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(course);
			session.getTransaction().commit();
		}catch (HibernateException e){
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Database Error",
							"Veri Güncellenirken Bir Sorun Oluştu"));
			session.getTransaction().rollback();
		}finally {
			session.close();
		}

	}

	@Override
	public void deleteData(Course t) {
		try{
			session= HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(t);
			session.getTransaction().commit();
		}catch (HibernateException e){
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Database Error",
							"Veri Silinirken Bir Sorun Oluştu"));
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
	}

}
