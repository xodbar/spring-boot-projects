package kz.xodbar.springprojects.big_project.services.impl;

import kz.xodbar.springprojects.big_project.entities.Task;
import kz.xodbar.springprojects.big_project.repositories.TaskRepository;
import kz.xodbar.springprojects.big_project.services.FolderService;
import kz.xodbar.springprojects.big_project.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImplementation implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private FolderService folderService;

    @Override
    public Task addNewTask(Task task) {
        try {
            return taskRepository.save(task);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Task getTaskById(Long id) {
        try {
            return taskRepository.getReferenceById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Task> getAllTasks() {
        try {
            return taskRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Task updateTask(Task task) {
        try {
            return taskRepository.save(task);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteTask(Long id) {
        try {
            taskRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Task> getTasksByFolder(Long folderId) {
        try {
            return taskRepository.findAllByTaskFolder(folderService.getFolderById(folderId));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
