package ua.axellos.kanbanrider.dto.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import ua.axellos.kanbanrider.dto.ProjectDto;
import ua.axellos.kanbanrider.model.Project;

import java.util.List;

@Mapper
public interface ProjectMapper {

    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

    @Mapping(source = "timestamps.createdAt", target = "createdAt")
    @Mapping(source = "timestamps.updatedAt", target = "updatedAt")
    ProjectDto map(Project project);

    Project map(ProjectDto projectDto);

    List<ProjectDto> map(List<Project> projects);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(ProjectDto projectDto, @MappingTarget Project project);
}
