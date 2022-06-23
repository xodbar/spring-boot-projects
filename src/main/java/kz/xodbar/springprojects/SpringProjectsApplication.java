package kz.xodbar.springprojects;

import kz.xodbar.springprojects.lectures.lecture3.config.L3T1Config;
import kz.xodbar.springprojects.lectures.lecture3.dao.TaskDAO;
import kz.xodbar.springprojects.lectures.lecture3.entities.Task;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@SpringBootApplication
public class SpringProjectsApplication {

    public static void main(String[] args) {
        ApplicationContext aps = SpringApplication.run(SpringProjectsApplication.class, args);
        for (String appContext : aps.getBeanDefinitionNames())
            System.out.println(appContext);

        ApplicationContext context =
                new AnnotationConfigApplicationContext(L3T1Config.class);

        context.getBean("taskDAO", TaskDAO.class).addNewTask(new Task(
                null,
                "New Task",
                Timestamp.valueOf(LocalDateTime.now()),
                false
        ));

        System.out.println(context.getBean("taskDAO", TaskDAO.class).getTaskById(1L).getName());
    }

}
