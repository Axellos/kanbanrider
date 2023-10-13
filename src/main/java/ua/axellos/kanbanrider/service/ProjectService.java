package ua.axellos.kanbanrider.service;

import ua.axellos.kanbanrider.dto.ProjectDto;
import ua.axellos.kanbanrider.model.Project;

import java.util.List;

public interface ProjectService {

    List<Project> findAllByOwnerId(String ownerId);

    Project create(ProjectDto project, String ownerId);
}
