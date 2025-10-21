package fr.greffet.api_uiux.service;

import fr.greffet.api_uiux.model.entity.Project;
import fr.greffet.api_uiux.model.entity.User;
import fr.greffet.api_uiux.model.repository.ProjectRepository;
import fr.greffet.api_uiux.model.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> findAllByUser(User user) {
        return this.projectRepository.findAllByUser(user);
    }

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public List<Project> findRecentsByUser(User user) {
        return this.projectRepository.findTop4ByUserOrderByCreatedAtDesc(user);
    }
}
