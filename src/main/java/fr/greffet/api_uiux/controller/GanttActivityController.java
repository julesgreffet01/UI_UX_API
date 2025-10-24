package fr.greffet.api_uiux.controller;


import fr.greffet.api_uiux.dto.GanttActivityDTO;
import fr.greffet.api_uiux.model.entity.GanttActivity;
import fr.greffet.api_uiux.service.GanttActivityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project/{idProject}/board/{idBoard}/activity")
public class GanttActivityController {

    private final GanttActivityService ganttActivityService;

    public GanttActivityController(GanttActivityService ganttActivityService) {
        this.ganttActivityService = ganttActivityService;
    }

    @GetMapping("")
    public ResponseEntity<List<GanttActivity>> getGanttActivities(@PathVariable Long idBoard) {
        List<GanttActivity> ganttActivities = this.ganttActivityService.getGanttActivities(idBoard);
        return ResponseEntity.ok().body(ganttActivities);
    }

    @PostMapping("")
    public ResponseEntity<GanttActivity> createGanttActivity(@PathVariable Long idBoard, @RequestBody GanttActivityDTO ganttActivityDTO) {
        GanttActivity ganttActivity = this.ganttActivityService.createActivity(idBoard, ganttActivityDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(ganttActivity);
    }
}
