package ua.axellos.kanbanrider.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.axellos.kanbanrider.model.listener.TimestampsListener;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "agile_boards")
@EntityListeners(TimestampsListener.class)
public class AgileBoard extends BaseEntity implements Timestampable {

    private String name;

    @Embedded
    private Timestamps timestamps;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;
}
