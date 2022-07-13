package kz.xodbar.springprojects.big_project.services.impl;

import kz.xodbar.springprojects.big_project.entities.Folder;
import kz.xodbar.springprojects.big_project.entities.TaskCategory;
import kz.xodbar.springprojects.big_project.repositories.FolderRepository;
import kz.xodbar.springprojects.big_project.services.FolderService;
import kz.xodbar.springprojects.big_project.services.TaskCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FolderServiceImplementation implements FolderService {
    @Autowired
    private FolderRepository folderRepository;

    @Autowired
    private TaskCategoryService taskCategoryService;

    @Override
    public Folder removeCategoryFromFolder(Long folderId, Long categoryId) {
        try {
            Folder temp = getFolderById(folderId);

            boolean folderContainsSuchCategory = false;
            for (TaskCategory category : temp.getFolderCategories())
                if (category.equals(taskCategoryService.getCategoryById(categoryId)))
                    folderContainsSuchCategory = true;

            if (!folderContainsSuchCategory)
                throw new Exception("No such category in this folder!");

            temp.getFolderCategories().remove(taskCategoryService.getCategoryById(categoryId));
            updateFolder(temp);

            return temp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Folder assignCategoryToFolder(Long folderId, String categoryName) {
        try {
            if (categoryName == null || categoryName.isEmpty())
                throw new Exception("Invalid category name");

            if (folderRepository.getReferenceById(folderId).getFolderCategories()
                    .contains(taskCategoryService.getCategoryByName(categoryName)))
                throw new Exception("Folder already has this category!");


            Folder temp = getFolderById(folderId);

            if (taskCategoryService.getCategoryByName(categoryName) == null)
                taskCategoryService.addNewCategory(new TaskCategory(null, categoryName));

            temp.getFolderCategories().add(taskCategoryService.getCategoryByName(categoryName));

            updateFolder(temp);

            return updateFolder(temp);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Folder addNewFolder(Folder folder) {
        try {
            return folderRepository.save(folder);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Folder getFolderById(Long id) {
        try {
            return folderRepository.getReferenceById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Folder> getAllFolders() {
        try {
            return folderRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Folder updateFolder(Folder folder) {
        try {
            return folderRepository.save(folder);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteFolder(Folder folder) {
        try {
            folderRepository.delete(folder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Folder> getFoldersByCategory(TaskCategory category) {
        try {
            return folderRepository.findFoldersByFolderCategories(category);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Folder> getFoldersByNameSearch(String folderName) {
        try {
            return folderRepository.findAllByFolderNameLikeIgnoreCase("%" + folderName + "%");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
