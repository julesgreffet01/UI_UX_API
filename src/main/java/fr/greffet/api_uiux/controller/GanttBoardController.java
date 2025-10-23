package fr.greffet.api_uiux.controller;

import fr.greffet.api_uiux.dto.GanttBoardDTO;
import fr.greffet.api_uiux.model.entity.GanttBoard;
import fr.greffet.api_uiux.service.GanttBoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project/{idProject}/board/")
public class GanttBoardController {
    private final GanttBoardService ganttBoardService;

    public GanttBoardController(GanttBoardService ganttBoardService) {
        this.ganttBoardService = ganttBoardService;
    }

    @GetMapping("")
    public ResponseEntity<List<GanttBoard>> getGanttBoard(@PathVariable Long idProject) {
        List<GanttBoard> ganttBoards = this.ganttBoardService.findGanttBoardsByProject(idProject);
        return ResponseEntity.ok().body(ganttBoards);
    }

    @PostMapping("")
    public ResponseEntity<GanttBoard> createGanttBoard(@PathVariable Long idProject, @RequestBody GanttBoardDTO ganttBoardDTO) {
        GanttBoard ganttBoard2 = this.ganttBoardService.createBoard(idProject, ganttBoardDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(ganttBoard2);
    }
}
