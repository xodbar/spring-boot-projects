package kz.xodbar.springprojects.big_project.repositories;

import kz.xodbar.springprojects.big_project.entities.Folder;
import kz.xodbar.springprojects.big_project.entities.TaskCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FolderRepository extends JpaRepository<Folder, Long> {
    @Query
    List<Folder> findFoldersByFolderCategories(TaskCategory category);

    @Query
    List<Folder> findAllByFolderNameLikeIgnoreCase(String folderName);
}
