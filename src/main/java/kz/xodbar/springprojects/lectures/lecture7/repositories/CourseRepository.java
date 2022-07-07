package kz.xodbar.springprojects.lectures.lecture7.repositories;

import kz.xodbar.springprojects.lectures.lecture7.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
