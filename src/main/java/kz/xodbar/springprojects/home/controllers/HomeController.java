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
        lectures.get(0).getTasks().add(new Task(2, "Продолжайте работать над заданием выше. " +
                "Создайте отдельную ссылку для добавления этих товаров. У вас должна быть возможность добавлять их в " +
                "список. А также просматривать их по отдельности, детальный просмотр.",
                "https://lh6.googleusercontent.com/5AssJy27xYYaK1Q6V4TTPRfbiobnfcUf9pGmd_TTVGHpobWeWosokMsctkXQPKBJenaS4eijo5UtKEJbz1GRfuNGktg2X-DepmouwlxXoav8fg63YN91UXje7rhfEWEZmNIwk_pJemoFJxrUoQ",
                "/", "/lecture1/task2"));

        lectures.add(new Lecture(
                3, "Thymeleaf", new ArrayList<>()
        ));
        lectures.get(1).getTasks().add(new Task(
                1, "Создайте ВЕБ приложение на Spring Boot используя библиотеку \"Thymeleaf\" в " +
                "качестве представления (view). Нужно будет разработать мини систему результатов экзамена студентов.  " +
                "Мне нужно будет хранить список студентов.",
                "https://lh5.googleusercontent.com/Xcf2YVFG3GLa1kkLj20vtQPvm73l-8LOrxZSziIqXcdIZWbuLFZyUp3j_AAo6McqoENsH8i3isVdBLAcWwzfKHZIfVWC9AjXkyR7G_1cmdjjOP3UtE6CIQpZueCHlXOkdWatA5eWz0V7ai-0Hw",
                "/", "/lecture3/task1"
        ));

        lectures.add(new Lecture(
                4, "Thymeleaf Layout Dialect", new ArrayList<>()
        ));

        lectures.get(2).getTasks().add(new Task(
                1, "Создайте ВЕБ приложение на Spring Boot используя библиотеку \"Thymeleaf\" " +
                "в качестве представления (view). Создайте основной макет (Layout) вашей страницы, используя библиотеку" +
                " \"Thymeleaf Layout Dialect\". Тема проекта заключается в менеджере задач. Для начала вам нужно будет " +
                "создать класс Task.java, с параметрами: Task.java",
                "https://lh6.googleusercontent.com/O6iKMlkdN3Axw1cdeDiw9_tsxkr4n_Ih7wQzAna3ZzBPUhy67drptcSqmFIS1X2HGzyTIhdhYZyhdw4vS5FcXF78yGB0KivIVT8j1q9EvpknAgBp-5iybTWqL7drAmP_YhvEVi28CjuCOmnlGg",
                "/", "lecture4/task1"
        ));

        return lectures;
    }
}
