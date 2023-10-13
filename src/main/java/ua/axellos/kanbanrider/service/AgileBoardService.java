package ua.axellos.kanbanrider.service;

import ua.axellos.kanbanrider.dto.AgileBoardDto;
import ua.axellos.kanbanrider.model.AgileBoard;

public interface AgileBoardService {

    AgileBoard create(Long projectId, AgileBoardDto agileBoardDto);
}
