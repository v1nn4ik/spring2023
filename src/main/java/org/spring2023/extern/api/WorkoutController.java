package org.spring2023.extern.api;

import lombok.AllArgsConstructor;
import org.spring2023.app.entity.UserEntity;
import org.spring2023.app.service.repository.ExerciseRepository;
import org.spring2023.app.service.repository.UserRepository;
import org.spring2023.app.service.repository.WorkoutRepository;
import org.spring2023.app.entity.ExerciseEntity;
import org.spring2023.app.entity.WorkoutEntity;
import org.spring2023.app.service.impl.WorkoutServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class WorkoutController {
    private final WorkoutRepository workoutRepository;
    private final WorkoutServiceImpl workoutService;

    private final ExerciseRepository exerciseRepository;

    private final UserRepository userRepository;

    @PostMapping("/{id}/workout")
    public WorkoutEntity saveWorkout(@RequestBody WorkoutEntity workout, @PathVariable Long id) {
        Optional<UserEntity> user = userRepository.findById(id);
        if (user.isPresent()) {
            workout.setUser(user.get());
        } else {
            throw new RuntimeException("Пользователь №" + id + "не найден");
        }
        return workoutRepository.save(workout);
    }

    @GetMapping("/workout")
    public Iterable<WorkoutEntity> getWorkout() {
        return workoutRepository.findAll();
    }

    @PutMapping("/workout/{id}")
    public WorkoutEntity updateWorkout(@RequestBody WorkoutEntity workout, @PathVariable Long id) {
        return workoutService.update(workout, id);
    }

    @PostMapping("/workout/{id}")
    public ExerciseEntity saveExercise(@RequestBody ExerciseEntity exercise, @PathVariable Long id) {
        Optional<WorkoutEntity> workout = workoutRepository.findById(id);
        if (workout.isPresent()) {
            exercise.setWorkout(workout.get());
        } else {
            throw new RuntimeException("Тренировка №" + id + "не найдена");
        }
        return exerciseRepository.save(exercise);
    }

    @GetMapping("/workout/exercises")
    public Iterable<ExerciseEntity> getExercise() {
        return exerciseRepository.findAll();
    }
}
