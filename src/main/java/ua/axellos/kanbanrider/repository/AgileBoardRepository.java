package ua.axellos.kanbanrider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.axellos.kanbanrider.model.AgileBoard;

import java.util.List;

public interface AgileBoardRepository extends JpaRepository<AgileBoard, Long> {

    List<AgileBoard> findAllByProjectId(Long projectId);
}
