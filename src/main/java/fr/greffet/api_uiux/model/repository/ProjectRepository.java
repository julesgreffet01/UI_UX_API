package fr.greffet.api_uiux.model.repository;

import fr.greffet.api_uiux.model.entity.Project;
import fr.greffet.api_uiux.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findAllByUser(User user);

    List<Project> findTop4ByUserOrderByCreatedAtDesc(User user);
}
