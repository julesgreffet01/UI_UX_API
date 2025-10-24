package fr.greffet.api_uiux.service;

import fr.greffet.api_uiux.dto.GanttActivityDTO;
import fr.greffet.api_uiux.model.entity.GanttActivity;
import fr.greffet.api_uiux.model.entity.GanttBoard;
import fr.greffet.api_uiux.model.repository.GanttActivityRepository;
import fr.greffet.api_uiux.model.repository.GanttBoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GanttActivityService {

    private final GanttActivityRepository ganttActivityRepository;
    private final GanttBoardRepository ganttBoardRepository;

    public GanttActivityService(GanttActivityRepository ganttActivityRepository,  GanttBoardRepository ganttBoardRepository) {
        this.ganttActivityRepository = ganttActivityRepository;
        this.ganttBoardRepository = ganttBoardRepository;
    }

    public List<GanttActivity> getGanttActivities(Long boardId) {
        GanttBoard ganttBoard = this.ganttBoardRepository.findById(boardId).orElseThrow();
        return ganttActivityRepository.findAllByBoard(ganttBoard);
    }

    public GanttActivity createActivity(Long boardId, GanttActivityDTO ganttActivityDTO) {
        GanttActivity ganttActivity = new GanttActivity();
        ganttActivity.setLabel(ganttActivityDTO.getLabel());
        ganttActivity.setStartDate(ganttActivityDTO.getStartDate());
        ganttActivity.setEndDate(ganttActivityDTO.getEndDate());
        GanttBoard ganttBoard = this.ganttBoardRepository.findById(boardId).orElseThrow();
        ganttActivity.setBoard(ganttBoard);
        return this.ganttActivityRepository.save(ganttActivity);
    }
}
