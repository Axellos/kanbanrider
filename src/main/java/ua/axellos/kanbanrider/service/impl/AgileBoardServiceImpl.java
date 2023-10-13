package ua.axellos.kanbanrider.service.impl;

import org.springframework.stereotype.Service;
import ua.axellos.kanbanrider.dto.AgileBoardColumnDto;
import ua.axellos.kanbanrider.dto.AgileBoardDto;
import ua.axellos.kanbanrider.dto.mapper.AgileBoardColumnMapper;
import ua.axellos.kanbanrider.dto.mapper.AgileBoardMapper;
import ua.axellos.kanbanrider.exception.ModelNotFoundException;
import ua.axellos.kanbanrider.model.AgileBoard;
import ua.axellos.kanbanrider.model.AgileBoardColumn;
import ua.axellos.kanbanrider.model.Project;
import ua.axellos.kanbanrider.repository.AgileBoardRepository;
import ua.axellos.kanbanrider.repository.ProjectRepository;
import ua.axellos.kanbanrider.service.AgileBoardService;

import java.util.Arrays;
import java.util.List;

@Service
public class AgileBoardServiceImpl implements AgileBoardService {

    private final ProjectRepository projectRepository;

    private final AgileBoardRepository agileBoardRepository;

    private static final List<AgileBoardColumnDto> defaultColumns = Arrays.asList(
            new AgileBoardColumnDto("Open", "open", 0, false),
            new AgileBoardColumnDto("In Progress", "in_progress", 1, false),
            new AgileBoardColumnDto("Fixed", "fixed", 2, false),
            new AgileBoardColumnDto("Closed", "closed", 3, true)
    );

    public AgileBoardServiceImpl(ProjectRepository projectRepository, AgileBoardRepository agileBoardRepository) {
        this.projectRepository = projectRepository;
        this.agileBoardRepository = agileBoardRepository;
    }

    @Override
    public AgileBoard create(Long projectId, AgileBoardDto agileBoardDto) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ModelNotFoundException("Project", projectId));

        AgileBoard agileBoard = AgileBoardMapper.INSTANCE.map(agileBoardDto);
        agileBoard.setProject(project);
        setDefaultColumns(agileBoard);

        return agileBoardRepository.save(agileBoard);
    }

    private void setDefaultColumns(AgileBoard agileBoard) {
        List<AgileBoardColumn> columns = AgileBoardColumnMapper.INSTANCE.map(defaultColumns);
        columns.forEach(column -> column.setAgileBoard(agileBoard));
        agileBoard.setColumns(columns);
    }
}
