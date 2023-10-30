package org.spring2023.extern.api;

import lombok.AllArgsConstructor;
import org.spring2023.app.entity.ExerciseEntity;
import org.spring2023.app.entity.WorkoutEntity;
import org.spring2023.app.service.impl.UserServiceImpl;
import org.spring2023.app.service.impl.WorkoutServiceImpl;
import org.spring2023.app.service.repository.ExerciseRepository;
import org.spring2023.app.service.repository.UserRepository;
import org.spring2023.app.entity.UserEntity;
import org.spring2023.app.service.repository.WorkoutRepository;
import org.spring2023.domain.User;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final UserServiceImpl userService;

    private final WorkoutRepository workoutRepository;
    private final WorkoutServiceImpl workoutService;

    private final ExerciseRepository exerciseRepository;

    @PostMapping
    public User saveUser(@RequestBody UserEntity user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public UserEntity updateUser(@RequestBody UserEntity user, @PathVariable Long id) {
        return userService.update(user, id);
    }

    @GetMapping
    public Iterable<UserEntity> findAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<UserEntity> findById(@PathVariable("id") Long id) {
        return userRepository.findById(id);
    }

    @PostMapping("{id}/workout")
    public WorkoutEntity saveWorkout(@RequestBody WorkoutEntity workout, @PathVariable Long id) {
        Optional<UserEntity> user = userRepository.findById(id);
        workout.setUser(user.get());
        return workoutRepository.save(workout);
    }

    @GetMapping("/workout")
    public Iterable<WorkoutEntity> getWorkout() {
        return workoutRepository.findAll();
    }

    @PutMapping("workout/{id}")
    public WorkoutEntity updateWorkout(@RequestBody WorkoutEntity workout, @PathVariable Long id) {
        return workoutService.update(workout, id);
    }

    @PostMapping("workout/{id}")
    public ExerciseEntity saveExercise(@RequestBody ExerciseEntity exercise, @PathVariable Long id) {
        Optional<WorkoutEntity> workout = workoutRepository.findById(id);
        exercise.setWorkout(workout.get());
        return exerciseRepository.save(exercise);
    }

    @GetMapping("workout/exercises")
    public Iterable<ExerciseEntity> getExercise() {
        return exerciseRepository.findAll();
    }
}
