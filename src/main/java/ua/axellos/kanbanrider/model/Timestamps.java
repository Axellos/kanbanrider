package ua.axellos.kanbanrider.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Getter
@Setter
@Embeddable
public class Timestamps {

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
