package kz.xodbar.springprojects.big_project.repositories;

import kz.xodbar.springprojects.big_project.entities.TaskCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskCategoryRepository extends JpaRepository<TaskCategory, Long> {
    @Query
    TaskCategory findByTaskCategoryName(String categoryName);
}
