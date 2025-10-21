package fr.greffet.api_uiux.service;

import fr.greffet.api_uiux.model.repository.GanttBoardRepository;
import org.springframework.stereotype.Service;

@Service
public class GanttBoardService {
    private final GanttBoardRepository ganttBoardRepository;

    public GanttBoardService(GanttBoardRepository ganttBoardRepository) {
        this.ganttBoardRepository = ganttBoardRepository;
    }


}
