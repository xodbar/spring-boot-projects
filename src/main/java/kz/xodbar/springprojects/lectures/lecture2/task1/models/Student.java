package kz.xodbar.springprojects.lectures.lecture2.task1.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Long id;
    private String name;
    private String surname;
    private Integer numEquivMark;
}
