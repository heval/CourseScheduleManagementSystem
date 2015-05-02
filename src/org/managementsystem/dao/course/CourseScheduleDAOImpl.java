package org.managementsystem.dao.course;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.managementsystem.controller.courseschedule.ICourseSchedule;
import org.managementsystem.HibernateUtil;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.Collections;
import java.util.List;

/**
 * Created by heval-Computer on 21.2.2015.
 */
public class CourseScheduleDAOImpl implements ICourseSchedule {
    Session session=null;

    @Override
    public List<Course> getDataListWhereSection() {
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
                            "Databasedeki Verilere Erişilemiyor"));
            return null;
        } finally {
            session.close();
        }
    }
}
