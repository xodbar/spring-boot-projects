package kz.xodbar.springprojects.big_project.services.impl;

import kz.xodbar.springprojects.big_project.entities.TaskCategory;
import kz.xodbar.springprojects.big_project.repositories.TaskCategoryRepository;
import kz.xodbar.springprojects.big_project.services.TaskCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskCategoryServiceImplementation implements TaskCategoryService {
    @Autowired
    private TaskCategoryRepository taskCategoryRepository;

    @Override
    public void addNewCategory(TaskCategory category) {
        try {
            taskCategoryRepository.save(category);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public TaskCategory getCategoryById(Long id) {
        try {
            return taskCategoryRepository.getReferenceById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<TaskCategory> getAllCategories() {
        try {
            return taskCategoryRepository.findAllByOrderByTaskCategoryNameAsc();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void updateCategory(TaskCategory category) {
        try {
            taskCategoryRepository.save(category);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCategory(TaskCategory category) {
        try {
            taskCategoryRepository.delete(category);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public TaskCategory getCategoryByName(String categoryName) {
        try {
            return taskCategoryRepository.findByTaskCategoryNameLike(categoryName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
