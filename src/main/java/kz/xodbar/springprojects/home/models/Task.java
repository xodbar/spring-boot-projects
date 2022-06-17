package kz.xodbar.springprojects.home.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Task {
    private Integer numberOfTask;
    private String description;
    private String imageUrl;
    private String githubUrl;
    private String url;
}
