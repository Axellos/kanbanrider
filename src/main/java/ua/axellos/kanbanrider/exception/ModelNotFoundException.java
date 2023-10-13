package ua.axellos.kanbanrider.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ModelNotFoundException extends RuntimeException {

    public ModelNotFoundException(String model, Long id) {
        super(model + " with id " + id + " not found");
    }
}
