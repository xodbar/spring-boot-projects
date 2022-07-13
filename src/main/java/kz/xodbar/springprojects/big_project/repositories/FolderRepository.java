package kz.xodbar.springprojects.big_project.repositories;

import kz.xodbar.springprojects.big_project.entities.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FolderRepository extends JpaRepository<Folder, Long> {
    @Query
    List<Folder> findFoldersByFolderCategories(Long categoryId);

    @Query (value = "SELECT * FROM folders f WHERE f.name LIKE ('%' + ?1 + '%')", nativeQuery = true)
    List<Folder> findAllByFolderName(String folderName);
}
