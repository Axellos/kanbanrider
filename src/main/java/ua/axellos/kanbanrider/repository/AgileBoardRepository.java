package ua.axellos.kanbanrider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.axellos.kanbanrider.model.AgileBoard;

public interface AgileBoardRepository extends JpaRepository<AgileBoard, Long> {

}
