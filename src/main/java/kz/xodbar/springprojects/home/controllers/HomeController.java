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
                "https://github.com/xodbar/spring-boot-projects/commit/7bf3cc4be61c6e906a409051d9b39b8ffc97f6ef", "/lecture1/task1"));
        lectures.get(0).getTasks().add(new Task(2, "Продолжайте работать над заданием выше. " +
                "Создайте отдельную ссылку для добавления этих товаров. У вас должна быть возможность добавлять их в " +
                "список. А также просматривать их по отдельности, детальный просмотр.",
                "https://lh6.googleusercontent.com/5AssJy27xYYaK1Q6V4TTPRfbiobnfcUf9pGmd_TTVGHpobWeWosokMsctkXQPKBJenaS4eijo5UtKEJbz1GRfuNGktg2X-DepmouwlxXoav8fg63YN91UXje7rhfEWEZmNIwk_pJemoFJxrUoQ",
                "https://github.com/xodbar/spring-boot-projects/commit/7bf3cc4be61c6e906a409051d9b39b8ffc97f6ef", "/lecture1/task2"));

        lectures.add(new Lecture(
                3, "Thymeleaf", new ArrayList<>()
        ));
        lectures.get(1).getTasks().add(new Task(
                1, "Создайте ВЕБ приложение на Spring Boot используя библиотеку \"Thymeleaf\" в " +
                "качестве представления (view). Нужно будет разработать мини систему результатов экзамена студентов.  " +
                "Мне нужно будет хранить список студентов.",
                "https://lh5.googleusercontent.com/Xcf2YVFG3GLa1kkLj20vtQPvm73l-8LOrxZSziIqXcdIZWbuLFZyUp3j_AAo6McqoENsH8i3isVdBLAcWwzfKHZIfVWC9AjXkyR7G_1cmdjjOP3UtE6CIQpZueCHlXOkdWatA5eWz0V7ai-0Hw",
                "https://github.com/xodbar/spring-boot-projects/commit/5bfe86a9229692afa7107a54b080a8b76939ce8b", "/lecture3/task1"
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
                "https://github.com/xodbar/spring-boot-projects/commit/899dd016eec61a70ec880c50416c4b53c6aabf7b", "/lecture4/task1"
        ));

        lectures.add(new Lecture(
                6, "Spring Data ORM", new ArrayList<>()
        ));

        lectures.get(3).getTasks().add(new Task(
                1, """
                Создайте ВЕБ приложение на Spring Boot используя библиотеку Thymeleaf в качестве представления (view).
                Создаем мини приложение заявок на обработку CRM системы. Для реализации данной задачи используем
                библиотеку Spring Data + MySQL или PostgreSQL. Создайте основной макет (Layout) вашей страницы,
                используя библиотеку Thymeleaf Layout Dialect.""",
                "https://lh4.googleusercontent.com/pYopHhyMtXep1-zr3HvZUopFboUakQDCe0NstFPNkc8JEjqrWbwY2XB4DtlWyKelIXtaqo_N8T7q4sUrFD80dt7tCh8EFfqT45igFf9KIaQJ5q_bYkVfIfEkCtA_zlx1wLPno75wg6Egxs69h2s",
                "https://github.com/xodbar/spring-boot-projects/commit/746d52a762576e584768347ce2f5fdd9e5552a1f", "/lecture7/task1"
        ));

        lectures.add(new Lecture(
                7, "ORM, Связки таблиц @ManyToOne", new ArrayList<>()
        ));

        lectures.get(4).getTasks().add(new Task(
                1, """
                Продолжаем работать над задачей заявок. Нужно будет создать дополнительную сущность (таблицу) курсов.
                                
                Courses.java
                - Long id;
                - String name;
                - String description;
                - int price;
                                
                Получается нам нужно будет изменить сущность заявки таким образом:
                                
                ApplicationRequest.java
                - Long id;
                - String userName;
                - String комментарий;
                - String phone;
                - boolean handled; //обработано или нет
                - Courses course; //@ManyToOne
                                
                Получается у вас будет заранее добавленный список всех возможных курсов в базе данных.\s
                                
                Про добавлении заявки, в выборке можете отобразить название курса и цену, как показано на примере:
                """,
                "https://lh3.googleusercontent.com/hGOINyIyJ9dfnsnz7YswEcPqhXjvT5q2r9hESTobAuCmU3cUmk338gvBk9ZOrcFH_fDU54erfdjD2PRr1OzIp3XYMYiYc73IqyhkNvFSOGMR-0ZXTfFQ8Te1D2XDPMEOZhbX3bAtu-7A_g1aRA",
                "https://github.com/xodbar/spring-boot-projects/commit/4f8d4e3cfb08e3f3d9bebd296085648a893ece88", "/lecture7/task1"
        ));

        lectures.add(new Lecture(
                9, "Big Project - Trello", new ArrayList<>()
        ));

        lectures.get(5).getTasks().add(new Task(
                1, """
                Задачей финального проекта является разработка приложения Trello на Spring Boot. Trello - это менеджер задач, в котором можно создавать карточки затем менять их статусы.\s
                                
                Сущности проекта (таблицы):
                                
                TaskCategories.java
                - Long id;
                - String name;
                                
                Folders.java
                - Long id;
                - String name;
                - List<TaskCategories> categories; // Many To Many
                                
                Tasks.java
                - Long id;
                - String title;
                - String description; // TEXT
                - int status; // 0 - todo, 1 - intest, 2 - done, 3 - failed
                - Folders folder; // Many To One
                                
                Comments.java
                - Long id;
                - String comment;
                - Task task;
                                
                Несмотря на то что мы используем 4 сущностей (5 таблиц), задача проект очень легкий.\s
                                
                По функционалу мы должны иметь возможность:
                                
                1. Добавить/изменить/удалить категорию задач (TaskCategories.java).
                2. Добавить/изменить/удалить папки (Folders.java). Причем при удалении папки, нужно будет удалить все задачи этой папки, и очистить связку категории и папки. Просто создайте в репозитории функцию которая удаляет связки по id.\s
                3. Создать/изменить/удалить задачу. Причем, просто так добавить задачу нельзя, обязательно надо выбрать папку (войти в нее) и создать внутри нее.\s
                4. Менять статус задачи. По умолчанию, статус задачи будет равна - 0 (todo). Если вы изменили статус задачи на 3 (done) или 4 (failed), то получается вы окончательно закрыли ее, то есть после этого нельзя будет комментировать или менять контент. Он будет доступен только в режиме просмотра.
                5. Можно будет комментировать задачку.
                """,
                "https://lh4.googleusercontent.com/XTwNLFg1ldwJA5KjMv5WvpQQkqvZ-iWjkL-XZBF5-NbqDDQuzzmvTUrWrvAY3N3fHJcsFKhwglm4a1uleARvk7YrVPCGAXKIfJpcX64gokWFdIqjewHFXlKuQtC1C-B2-3HBnQC8P314EGGVy0k",
                "https://github.com/xodbar/spring-boot-projects/commit/35f02f63ba0d55e98cdbdc20a4e8a5831e1fdcdc", "/trello"
        ));

        return lectures;
    }
}
