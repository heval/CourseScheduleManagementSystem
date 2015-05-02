package org.managementsystem.controller.courseschedule;

import org.managementsystem.model.course.Course;

import java.util.List;

/**
 * Created by heval-Computer on 21.2.2015.
 */
public class CourseScheduleController {
    private ICourseSchedule dao;

    public CourseScheduleController(ICourseSchedule dao) {
        this.dao = dao;
    }

    public ICourseSchedule getDao() {
        return dao;
    }

    public void setDao(ICourseSchedule dao) {
        this.dao = dao;
    }
    public List<Course> getCourseDataListWhereSection() {
        return dao.getDataListWhereSection();
    }

}
