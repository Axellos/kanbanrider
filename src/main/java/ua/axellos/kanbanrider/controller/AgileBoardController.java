package ua.axellos.kanbanrider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.axellos.kanbanrider.dto.AgileBoardDto;
import ua.axellos.kanbanrider.dto.mapper.AgileBoardMapper;
import ua.axellos.kanbanrider.model.AgileBoard;
import ua.axellos.kanbanrider.service.AgileBoardService;

@RestController
@RequestMapping("api/projects/{projectId}/agile-boards")
public class AgileBoardController {

    private final AgileBoardService agileBoardService;

    public AgileBoardController(AgileBoardService agileBoardService) {
        this.agileBoardService = agileBoardService;
    }

    @PostMapping
    @PreAuthorize("@projectAccessManager.canCreateAgileBoards(#projectId, authentication)")
    public ResponseEntity<AgileBoardDto> createAgileBoard(@PathVariable Long projectId, @RequestBody @Validated AgileBoardDto agileBoardDto) {
        AgileBoard agileBoard = agileBoardService.create(projectId, agileBoardDto);

        return new ResponseEntity<>(AgileBoardMapper.INSTANCE.map(agileBoard), HttpStatus.CREATED);
    }
}
