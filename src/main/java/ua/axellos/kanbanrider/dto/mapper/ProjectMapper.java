package ua.axellos.kanbanrider.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ua.axellos.kanbanrider.dto.ProjectDto;
import ua.axellos.kanbanrider.model.Project;

import java.util.List;

@Mapper
public interface ProjectMapper {

    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

    @Mapping(source = "timestamps.createdAt", target = "createdAt")
    ProjectDto map(Project project);

    Project map(ProjectDto projectDto);

    List<ProjectDto> map(List<Project> projects);
}
