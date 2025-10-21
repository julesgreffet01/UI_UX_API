package fr.greffet.api_uiux.model.repository;

import fr.greffet.api_uiux.model.entity.GanttBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GanttBoardepository extends JpaRepository<GanttBoard, Long> {
}
