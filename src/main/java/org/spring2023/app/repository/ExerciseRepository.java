package org.spring2023.app.repository;

import org.spring2023.app.entity.ExerciseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends CrudRepository<ExerciseEntity, Long> {
}
