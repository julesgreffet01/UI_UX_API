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
    private ProjectRepository projectRepository;
    private UserRepository userRepository;

    public ProjectService(ProjectRepository projectRepository, UserRepository userRepository) {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
    }

    public List<Project> findAllByUser(String email) {
        Optional<User> optionalUser = this.userRepository.findByEmail(email);
        User user = optionalUser.orElseThrow(() -> new RuntimeException("pas de user"));
        List<Project> projects = this.projectRepository.findAllByUser(user);
        return projects;
    }
}
