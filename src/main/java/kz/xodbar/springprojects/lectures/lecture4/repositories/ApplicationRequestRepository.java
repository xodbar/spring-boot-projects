package kz.xodbar.springprojects.lectures.lecture4.repositories;

import kz.xodbar.springprojects.lectures.lecture4.entities.ApplicationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ApplicationRequestRepository extends JpaRepository<ApplicationRequest, Long> {
    List<ApplicationRequest> findAllByHandledTrue();
    List<ApplicationRequest> findAllByHandledFalse();
    List<ApplicationRequest> findAllByCommentaryIsLike(String query);
    void deleteAllByHandledTrue();

    @Modifying
    @Query(value = "UPDATE ApplicationRequest r SET r.handled = true WHERE r.id = :id")
    void handleRequestById(@Param("id") Long id);
}
