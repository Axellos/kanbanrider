package ua.axellos.kanbanrider.service.impl;

import org.springframework.stereotype.Service;
import ua.axellos.kanbanrider.dto.ProjectDto;
import ua.axellos.kanbanrider.dto.mapper.ProjectMapper;
import ua.axellos.kanbanrider.exception.ProjectNameIsUsedException;
import ua.axellos.kanbanrider.model.Project;
import ua.axellos.kanbanrider.repository.ProjectRepository;
import ua.axellos.kanbanrider.service.ProjectService;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> findAllByOwnerId(String ownerId) {
        return projectRepository.findAllByOwnerId(ownerId);
    }

    @Override
    public Project create(ProjectDto projectDto, String ownerId) {
        checkIfProjectNameUniqueForOwner(projectDto.getName(), ownerId);
        Project project = ProjectMapper.INSTANCE.map(projectDto);
        project.setOwnerId(ownerId);

        return projectRepository.save(project);
    }

    private void checkIfProjectNameUniqueForOwner(String name, String ownerId) {
        if (projectRepository.existsByNameAndOwnerId(name, ownerId)) {
            throw new ProjectNameIsUsedException(name);
        }
    }
}
