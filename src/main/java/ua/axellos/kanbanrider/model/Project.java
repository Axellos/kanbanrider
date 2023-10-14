package ua.axellos.kanbanrider.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.axellos.kanbanrider.model.listener.TimestampsListener;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "projects")
@EntityListeners(TimestampsListener.class)
public class Project extends BaseEntity implements Timestampable {

    private String name;

    private String ownerId;

    private String prefix;

    private Integer startingNumber;

    private String description;

    @Embedded
    private Timestamps timestamps;
}
