package kz.xodbar.springprojects.home.controllers;

import kz.xodbar.springprojects.home.models.Lecture;
import kz.xodbar.springprojects.home.models.Task;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class HomeController {
    @GetMapping(value = "/")
    public ModelAndView getHomePage() {
        return new ModelAndView("home", "lectures", init());
    }

    private ArrayList<Lecture> init() {
        ArrayList<Lecture> lectures = new ArrayList<>();

        lectures.add(new Lecture(
                1, "Создание проекта Spring Boot", new ArrayList<>()
        ));
        lectures.get(0).getTasks().add(new Task(1, "Создайте первое ВЕБ приложение на Spring Boot " +
                "используя сборщик Apache Maven или Gradle. В качестве представления (view) используйте - Thymeleaf. " +
                "Подключение к базе данных не обязательно. Данные вы можете хранить в списке - List, ArrayList.",
                "https://lh6.googleusercontent.com/5AssJy27xYYaK1Q6V4TTPRfbiobnfcUf9pGmd_TTVGHpobWeWosokMsctkXQPKBJenaS4eijo5UtKEJbz1GRfuNGktg2X-DepmouwlxXoav8fg63YN91UXje7rhfEWEZmNIwk_pJemoFJxrUoQ",
                "/", "/lecture1/task1"));

        lectures.add(new Lecture(
                2, "Контроллеры Spring", new ArrayList<>()
        ));

        return lectures;
    }
}
