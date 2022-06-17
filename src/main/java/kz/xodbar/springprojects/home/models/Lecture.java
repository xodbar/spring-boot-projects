package kz.xodbar.springprojects.home.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;

@AllArgsConstructor
@Getter
public class Lecture {
    private Integer numberOfLecture;
    private String nameOfLecture;
    private ArrayList<Task> tasks;
}
