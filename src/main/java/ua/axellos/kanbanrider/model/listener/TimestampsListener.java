package ua.axellos.kanbanrider.model.listener;

import ua.axellos.kanbanrider.model.Timestampable;
import ua.axellos.kanbanrider.model.Timestamps;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public class TimestampsListener {

    @PrePersist
    public void setCreatedAt(Object object) {
        if (! (object instanceof Timestampable)) {
            return;
        }

        Timestampable timestampable = (Timestampable) object;
        Timestamps timestamps = timestampable.getTimestamps();

        if (timestamps == null) {
            timestamps = new Timestamps();
            timestampable.setTimestamps(timestamps);
        }

        timestamps.setCreatedAt(LocalDateTime.now());
    }

    @PreUpdate
    public void setUpdatedAt(Object object) {
        if (! (object instanceof Timestampable)) {
            return;
        }

        Timestampable timestampable = (Timestampable) object;
        Timestamps timestamps = timestampable.getTimestamps();

        timestamps.setUpdatedAt(LocalDateTime.now());
    }
}
