package kz.xodbar.springprojects.big_project.services;

import kz.xodbar.springprojects.big_project.entities.Folder;

import java.util.List;

public interface FolderService {
    Folder addNewFolder(Folder folder);
    Folder getFolderById(Long id);
    List<Folder> getAllFolders();
    Folder updateFolder(Folder folder);
    void deleteFolder(Folder folder);

    List<Folder> getFoldersByCategory(Long categoryId);
    List<Folder> getFoldersByNameSearch(String folderName);
    Folder assignCategoryToFolder(Long folderId, String categoryId);
    Folder removeCategoryFromFolder(Long folderId, Long categoryId);
}
