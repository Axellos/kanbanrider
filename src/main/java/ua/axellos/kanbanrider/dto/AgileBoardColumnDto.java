package ua.axellos.kanbanrider.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class AgileBoardColumnDto {

    private Long id;

    @Size(max = 255)
    @NotNull
    @NotBlank
    private String name;

    private String type;

    private int order;

    private boolean isResolved;

    public AgileBoardColumnDto(String name, String type, int order, boolean isResolved) {
        this.name = name;
        this.type = type;
        this.order = order;
        this.isResolved = isResolved;
    }
}
