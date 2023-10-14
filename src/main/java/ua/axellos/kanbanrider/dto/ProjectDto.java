package ua.axellos.kanbanrider.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {

    private Long id;

    @Size(max = 255)
    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String prefix;

    @NotNull
    @Min(1)
    private Integer startingNumber;

    @Size(max = 2000)
    private String description;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
