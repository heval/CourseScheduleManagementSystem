package org.managementsystem.controller.courseschedule;

import org.managementsystem.model.course.Course;

import java.util.List;

/**
 * Created by heval-Computer on 21.2.2015.
 */
public interface ICourseSchedule {
    public List<Course> getDataListWhereSection();
}
