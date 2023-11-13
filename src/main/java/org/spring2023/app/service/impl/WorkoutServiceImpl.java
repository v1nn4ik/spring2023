package org.spring2023.app.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.spring2023.app.repository.WorkoutRepository;
import org.spring2023.app.entity.WorkoutEntity;
import org.spring2023.app.service.WorkoutService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class WorkoutServiceImpl implements WorkoutService {
    private WorkoutRepository workoutRepository;
    @Override
    public WorkoutEntity update(WorkoutEntity workoutEntity, Long id) {
        return workoutRepository.findById(id).map(workout -> {
            workout.setName(workoutEntity.getName());
            workout.setType(workoutEntity.getType());
            workout.setPurpose(workoutEntity.getPurpose());
            workout.setDifficulty(workoutEntity.getDifficulty());
            workout.setDuration(workoutEntity.getDuration());
            workout.setApproaches(workoutEntity.getApproaches());
            workout.setExercises(workoutEntity.getExercises());
            workout.setEquipment(workoutEntity.getEquipment());
            workout.setProgress(workoutEntity.getProgress());
            workout.setPhoto(workoutEntity.getPhoto());
            workout.setNote(workoutEntity.getNote());
            workout.setDate(workoutEntity.getDate());
            workout.setLocation(workoutEntity.getLocation());
            log.info("\nТренировка №" + id + " изменена");
            return workoutRepository.save(workout);
        }).orElseThrow(() -> new RuntimeException("\nТренировка с №" + id + " не найдена"));
    }
}
