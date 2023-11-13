package org.spring2023.app.repository;

import org.spring2023.app.entity.WorkoutEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutRepository extends CrudRepository<WorkoutEntity, Long> {
}
