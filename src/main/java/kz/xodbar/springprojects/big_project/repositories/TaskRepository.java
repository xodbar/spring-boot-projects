package kz.xodbar.springprojects.big_project.repositories;

import kz.xodbar.springprojects.big_project.entities.Folder;
import kz.xodbar.springprojects.big_project.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query
    List<Task> findAllByTaskFolder(Folder folder);
}
