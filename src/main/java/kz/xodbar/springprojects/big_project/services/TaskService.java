package kz.xodbar.springprojects.big_project.services;

import kz.xodbar.springprojects.big_project.entities.Folder;
import kz.xodbar.springprojects.big_project.entities.Task;

import java.util.List;

public interface TaskService {
    Task addNewTask(Task task);
    Task getTaskById(Long id);
    List<Task> getAllTasks();
    Task updateTask(Task task);
    void deleteTask(Long id);

    List<Task> getTasksByFolder(Long folderId);
}
