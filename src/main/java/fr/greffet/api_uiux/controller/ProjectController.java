package fr.greffet.api_uiux.controller;

import fr.greffet.api_uiux.dto.ProjectDTO;
import fr.greffet.api_uiux.model.entity.Project;
import fr.greffet.api_uiux.model.entity.User;
import fr.greffet.api_uiux.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project/")
public class ProjectController {

    private final ProjectService projectService;
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("")
    public ResponseEntity<List<Project>> findAllByUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        List<Project> projects = this.projectService.findAllByUser(user);
        return ResponseEntity.ok(projects);
    }

    @GetMapping("/recents")
    public ResponseEntity<List<Project>> findRecentProjectsByUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        List<Project> projects = this.projectService.findRecentsByUser(user);
        return ResponseEntity.ok(projects);
    }

    @PostMapping("")
    public ResponseEntity<Project> createProject(@Valid @RequestBody ProjectDTO project) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        Project project1 = new Project();
        project1.setName(project.getName());
        project1.setUser(user);
        Project project2 = this.projectService.createProject(project1);
        return ResponseEntity.ok(project2);
    }
}
