package kz.xodbar.springprojects.lectures.lecture2.task1.db;

import kz.xodbar.springprojects.lectures.lecture2.task1.models.Student;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class StaticDBManager {
    public static final StaticDBManager MANAGER = new StaticDBManager();
    private final ArrayList<Student> STUDENTS;
    private Long id;

    private StaticDBManager() {
        STUDENTS = new ArrayList<>();
        id = 1L;
    }

    public void addStudent(Student student) {
        STUDENTS.add(new Student(
                id,
                student.getName(),
                student.getSurname(),
                student.getNumEquivMark()
        ));
        id++;
    }
}
