package kz.xodbar.springprojects.lectures.lecture1.task2.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Item {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer amount;
}
