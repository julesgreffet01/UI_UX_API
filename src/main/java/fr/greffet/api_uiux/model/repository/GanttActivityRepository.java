package fr.greffet.api_uiux.model.repository;

import fr.greffet.api_uiux.model.entity.GanttActivity;
import fr.greffet.api_uiux.model.entity.GanttBoard;
import fr.greffet.api_uiux.model.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GanttActivityRepository extends JpaRepository<GanttActivity, Long> {
    List<GanttActivity> findAllByBoard(GanttBoard ganttBoard);
}
