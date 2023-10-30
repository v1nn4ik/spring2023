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
@RequestMapping("/user/workout")
@AllArgsConstructor
public class WorkoutController {
//    private final WorkoutRepository workoutRepository;
//    private final WorkoutServiceImpl workoutService;
//
//    private final ExerciseRepository exerciseRepository;
//
//    private final UserRepository userRepository;
//
//    @PostMapping("/{id}")
//    public WorkoutEntity saveWorkout(@RequestBody WorkoutEntity workout, @PathVariable Long id) {
//        Optional<UserEntity> user = userRepository.findById(id);
//        workout.setUser(user.get());
//        return workoutRepository.save(workout);
//    }
//
//    @GetMapping()
//    public Iterable<WorkoutEntity> getWorkout() {
//        return workoutRepository.findAll();
//    }
//
//    @PutMapping("/{id}")
//    public WorkoutEntity updateWorkout(@RequestBody WorkoutEntity workout, @PathVariable Long id) {
//        return workoutService.update(workout, id);
//    }
//
//    @PostMapping("/{id}")
//    public ExerciseEntity saveExercise(@RequestBody ExerciseEntity exercise, @PathVariable Long id) {
//        Optional<WorkoutEntity> workout = workoutRepository.findById(id);
//        exercise.setWorkout(workout.get());
//        return exerciseRepository.save(exercise);
//    }
//
//    @GetMapping("/exercises")
//    public Iterable<ExerciseEntity> getExercise() {
//        return exerciseRepository.findAll();
//    }
}
