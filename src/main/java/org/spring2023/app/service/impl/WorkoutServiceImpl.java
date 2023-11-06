package org.spring2023.app.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.spring2023.app.service.repository.WorkoutRepository;
import org.spring2023.app.entity.WorkoutEntity;
import org.spring2023.app.service.WorkoutService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class WorkoutServiceImpl implements WorkoutService {
    private WorkoutRepository workoutRepository;
    @Override
    public WorkoutEntity update(WorkoutEntity workoutEntity, Long id) {
        Optional<WorkoutEntity> optionalWorkout = workoutRepository.findById(id);
        if (optionalWorkout.isPresent()) {
            WorkoutEntity existWorkout = optionalWorkout.get();
            existWorkout.setName(workoutEntity.getName());
            existWorkout.setType(workoutEntity.getType());
            existWorkout.setPurpose(workoutEntity.getPurpose());
            existWorkout.setDifficulty(workoutEntity.getDifficulty());
            existWorkout.setDuration(workoutEntity.getDuration());
            existWorkout.setApproaches(workoutEntity.getApproaches());
            existWorkout.setExercises(workoutEntity.getExercises());
            existWorkout.setEquipment(workoutEntity.getEquipment());
            existWorkout.setProgress(workoutEntity.getProgress());
            existWorkout.setPhoto(workoutEntity.getPhoto());
            existWorkout.setNote(workoutEntity.getNote());
            existWorkout.setDate(workoutEntity.getDate());
            existWorkout.setLocation(workoutEntity.getLocation());
            log.info("\nТренировка №" + id + " изменена");
            return workoutRepository.save(existWorkout);
        } else {
            throw new RuntimeException("\nТренировка с №" + id + " не найдена");
        }
    }
}
