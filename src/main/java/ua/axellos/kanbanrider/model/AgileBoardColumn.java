package ua.axellos.kanbanrider.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "agile_board_columns")
public class AgileBoardColumn extends BaseEntity {

    private String name;

    private String type;

    private int order;

    private boolean isResolved;

    @ManyToOne
    @JoinColumn(name = "agile_board_id", nullable = false)
    private AgileBoard agileBoard;
}
