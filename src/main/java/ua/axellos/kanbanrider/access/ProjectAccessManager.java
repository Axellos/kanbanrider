package ua.axellos.kanbanrider.access;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import ua.axellos.kanbanrider.repository.ProjectRepository;

@Component
public class ProjectAccessManager {

    private final ProjectRepository projectRepository;

    public ProjectAccessManager(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public boolean canUpdateProject(Long projectId, Authentication authentication) {
        return projectRepository.existsByIdAndOwnerId(projectId, authentication.getName());
    }
}
