package ua.axellos.kanbanrider.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ua.axellos.kanbanrider.exception.ProjectNameIsUsedException;

import java.util.Map;

@ControllerAdvice
public class BusinessLogicExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<?> handleProjectNameTakenException(ProjectNameIsUsedException exception) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Map.ofEntries(Map.entry("email", exception.getMessage())));
    }
}
