package kz.xodbar.springprojects.lectures.lecture7.repositories;

import kz.xodbar.springprojects.lectures.lecture7.entities.ApplicationRequestUpdated;
import kz.xodbar.springprojects.lectures.lecture7.entities.Operator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ApplicationRequestRepositoryUpdated extends JpaRepository<ApplicationRequestUpdated, Long> {
    List<ApplicationRequestUpdated> findAllByHandledTrue();
    List<ApplicationRequestUpdated> findAllByHandledFalse();
    List<ApplicationRequestUpdated> findAllByCommentaryIsLike(String query);
    void deleteAllByHandledTrue();

    @Modifying
    @Query(value = "UPDATE ApplicationRequestUpdated r SET r.handled = true WHERE r.id = :id")
    void handleRequestById(@Param("id") Long id);
}
