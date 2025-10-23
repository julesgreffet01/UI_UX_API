package fr.greffet.api_uiux.model.repository;

import fr.greffet.api_uiux.model.entity.GanttBoard;
import fr.greffet.api_uiux.model.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GanttBoardRepository extends JpaRepository<GanttBoard, Long> {
    @Query("SELECT g FROM GanttBoard g WHERE g.project.id = :projectId")
    List<GanttBoard> findByProjectId(@Param("projectId") Long projectId);
}
