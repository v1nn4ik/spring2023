package org.spring2023.app.repository;

import org.spring2023.app.entity.WorkoutEntity;
import org.spring2023.domain.Difficulty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutRepository extends JpaRepository<WorkoutEntity, Long> {
    List<WorkoutEntity> findByDifficulty(Difficulty difficulty);
}
