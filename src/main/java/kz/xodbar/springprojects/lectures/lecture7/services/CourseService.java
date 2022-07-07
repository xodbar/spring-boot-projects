package kz.xodbar.springprojects.lectures.lecture7.services;

import kz.xodbar.springprojects.lectures.lecture7.entities.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();
    Course getCourseById(Long id);
}
