package fr.greffet.api_uiux.model.repository;

import fr.greffet.api_uiux.model.entity.GanttActivity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GanttActivityRepository extends JpaRepository<GanttActivity, Long> {
}
