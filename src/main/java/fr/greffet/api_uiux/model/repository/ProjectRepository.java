package fr.greffet.api_uiux.model.repository;

import fr.greffet.api_uiux.model.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("SELECT p FROM Project p JOIN FETCH p.user")
    List<Project> findAllWithUsers();
}
