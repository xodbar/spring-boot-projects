package kz.xodbar.springprojects.lectures.lecture7.services.impl;

import kz.xodbar.springprojects.lectures.lecture7.entities.Course;
import kz.xodbar.springprojects.lectures.lecture7.repositories.CourseRepository;
import kz.xodbar.springprojects.lectures.lecture7.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImplementation implements CourseService {
    @Autowired
    private CourseRepository repository;

    @Override
    public List<Course> getAllCourses() {
        return repository.findAll();
    }

    @Override
    public Course getCourseById(Long id) {
        return repository.getReferenceById(id);
    }
}
