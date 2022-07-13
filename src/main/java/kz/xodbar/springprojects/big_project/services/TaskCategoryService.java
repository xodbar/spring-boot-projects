package kz.xodbar.springprojects.big_project.services;

import kz.xodbar.springprojects.big_project.entities.TaskCategory;

import java.util.List;

public interface TaskCategoryService {
    void addNewCategory(TaskCategory category);
    TaskCategory getCategoryById(Long id);
    List<TaskCategory> getAllCategories();
    void updateCategory(TaskCategory category);
    void deleteCategory(TaskCategory category);

    TaskCategory getCategoryByName(String categoryName);
}
