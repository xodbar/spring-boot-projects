package kz.xodbar.springprojects.lectures.lecture3.dao;

import kz.xodbar.springprojects.lectures.lecture3.entities.Task;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Getter
public class TaskDAO {
    private final ArrayList<Task> tasks;
    private Long id;

    private static TaskDAO instance;

    private TaskDAO() {
        this.tasks = new ArrayList<>();
        id = 1L;
    }

    public static TaskDAO getInstance() {
        if (instance == null)
            instance = new TaskDAO();

        return instance;
    }

    public void addNewTask(Task task) {
        try {
            task.setId(id);
            tasks.add(task);
            id++;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Task getTaskById(Long id) {
        Task result = new Task();

        for (Task task : tasks)
            if (task.getId().equals(id))
                result = task;

        return result;
    }

    public void updateTask(Task task) {
        try {
            for (int i = 0; i < tasks.size(); i++) {
                if (tasks.get(i).getId().equals(task.getId())) {
                    tasks.set(i, task);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteTask(Long id) {
        try {
            for (int i = 0; i < tasks.size(); i++) {
                if (tasks.get(i).getId().equals(id)) {
                    tasks.remove(i);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
