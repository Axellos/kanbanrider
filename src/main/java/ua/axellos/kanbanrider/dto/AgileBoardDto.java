package ua.axellos.kanbanrider.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AgileBoardDto {

    private int id;

    @Size(max = 255)
    @NotNull
    @NotBlank
    private String name;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
