package fr.greffet.api_uiux.service;

import fr.greffet.api_uiux.dto.GanttBoardDTO;
import fr.greffet.api_uiux.model.entity.GanttBoard;
import fr.greffet.api_uiux.model.entity.Project;
import fr.greffet.api_uiux.model.repository.GanttBoardRepository;
import fr.greffet.api_uiux.model.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GanttBoardService {
    private final GanttBoardRepository ganttBoardRepository;
    private final ProjectRepository projectRepository;

    public GanttBoardService(GanttBoardRepository ganttBoardRepository,  ProjectRepository projectRepository) {
        this.ganttBoardRepository = ganttBoardRepository;
        this.projectRepository = projectRepository;
    }

    public List<GanttBoard> findGanttBoardsByProject(Long projectId) {
        return this.ganttBoardRepository.findByProjectId(projectId);
    }

    public GanttBoard createBoard(Long idProject, GanttBoardDTO dto) {
        Project project = projectRepository.findById(idProject)
                .orElseThrow(() -> new RuntimeException("Projet introuvable"));

        GanttBoard ganttBoard = new GanttBoard();
        ganttBoard.setProject(project);
        ganttBoard.setName(dto.getName());

        return ganttBoardRepository.save(ganttBoard);
    }
}
