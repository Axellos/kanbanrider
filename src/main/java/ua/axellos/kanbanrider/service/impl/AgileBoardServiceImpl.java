package ua.axellos.kanbanrider.service.impl;

import org.springframework.stereotype.Service;
import ua.axellos.kanbanrider.dto.AgileBoardDto;
import ua.axellos.kanbanrider.dto.mapper.AgileBoardMapper;
import ua.axellos.kanbanrider.exception.ModelNotFoundException;
import ua.axellos.kanbanrider.model.AgileBoard;
import ua.axellos.kanbanrider.model.Project;
import ua.axellos.kanbanrider.repository.AgileBoardRepository;
import ua.axellos.kanbanrider.repository.ProjectRepository;
import ua.axellos.kanbanrider.service.AgileBoardService;

@Service
public class AgileBoardServiceImpl implements AgileBoardService {

    private final ProjectRepository projectRepository;

    private final AgileBoardRepository agileBoardRepository;

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

        return agileBoardRepository.save(agileBoard);
    }
}
