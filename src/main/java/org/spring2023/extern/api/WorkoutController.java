package org.spring2023.extern.api;

import lombok.AllArgsConstructor;
import org.spring2023.app.entity.UserEntity;
import org.spring2023.app.repository.ExerciseRepository;
import org.spring2023.app.repository.UserRepository;
import org.spring2023.app.repository.WorkoutRepository;
import org.spring2023.app.entity.ExerciseEntity;
import org.spring2023.app.entity.WorkoutEntity;
import org.spring2023.app.service.impl.WorkoutServiceImpl;
import org.spring2023.domain.Difficulty;
import org.spring2023.extern.converter.ExerciseConverter;
import org.spring2023.extern.converter.WorkoutConverter;
import org.spring2023.extern.dto.ExerciseDto;
import org.spring2023.extern.dto.WorkoutDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class WorkoutController {
    private final WorkoutRepository workoutRepository;
    private final WorkoutServiceImpl workoutService;
    private final WorkoutConverter workoutConverter;

    private final ExerciseRepository exerciseRepository;
    private final ExerciseConverter exerciseConverter;

    private final UserRepository userRepository;

    @PostMapping("/{id}/workout")
    public WorkoutDto saveWorkout(@RequestBody WorkoutDto workoutDto, @PathVariable Long id) {
        WorkoutEntity workoutEntity = workoutConverter.toEntity(workoutDto);
        Optional<UserEntity> user = userRepository.findById(id);

        if (user.isPresent()) {
            workoutEntity.setUser(user.get());
        } else {
            throw new RuntimeException("Пользователь №" + id + "не найден");
        }

        return workoutConverter.toDto(workoutRepository.save(workoutEntity));
    }

    @GetMapping("/workout")
    public List<WorkoutDto> getWorkout() {
        Iterable<WorkoutEntity> workoutEntities = workoutRepository.findAll();
        List<WorkoutDto> workoutDtos = new ArrayList<>();
        for (WorkoutEntity workout : workoutEntities) {
            workoutDtos.add(workoutConverter.toDto(workout));
        }
        return workoutDtos;
    }

    @PutMapping("/workout/{id}")
    public WorkoutDto updateWorkout(@RequestBody WorkoutDto workoutDto, @PathVariable Long id) {
        WorkoutEntity workoutEntity = workoutConverter.toEntity(workoutDto);
        return workoutConverter.toDto(workoutService.update(workoutEntity, id));
    }

    @PostMapping("/workout/{id}")
    public ExerciseDto saveExercise(@RequestBody ExerciseDto exerciseDto, @PathVariable Long id) {
        ExerciseEntity exerciseEntity = exerciseConverter.toEntity(exerciseDto);
        Optional<WorkoutEntity> workout = workoutRepository.findById(id);

        if (workout.isPresent()) {
            exerciseEntity.setWorkout(workout.get());
        } else {
            throw new RuntimeException("Тренировка №" + id + "не найдена");
        }

        return exerciseConverter.toDto(exerciseRepository.save(exerciseEntity));
    }

    @GetMapping("/workout/exercises")
    public List<ExerciseDto> getExercise() {
        Iterable<ExerciseEntity> exerciseEntities = exerciseRepository.findAll();
        List<ExerciseDto> exerciseDtos =  new ArrayList<>();
        for (ExerciseEntity exercise : exerciseEntities) {
            exerciseDtos.add(exerciseConverter.toDto(exercise));
        }
        return exerciseDtos;
    }

    @GetMapping("/workout/difficulty/{difficulty}")
    public List<WorkoutDto> getWorkoutByDifficulty(@PathVariable Difficulty difficulty) {
        List<WorkoutEntity> workoutEntities = workoutService.getWorkoutByDifficulty(difficulty);
        List<WorkoutDto> workoutDtos = new ArrayList<>();
        for (WorkoutEntity workout : workoutEntities) {
            workoutDtos.add(workoutConverter.toDto(workout));
        }
        return workoutDtos;
    }

    @GetMapping("/workout/difficulty_up")
    public List<WorkoutDto> getSortedByDifficultyAsc() {
        List<WorkoutEntity> workoutEntities = workoutService.getSortedWorkoutByDifficultyAsc();
        List<WorkoutDto> workoutDtos = new ArrayList<>();
        for (WorkoutEntity workout : workoutEntities) {
            workoutDtos.add(workoutConverter.toDto(workout));
        }
        return workoutDtos;
    }

    @GetMapping("/workout/difficulty_down")
    public List<WorkoutDto> getSortedByDifficultyDesc() {
        List<WorkoutEntity> workoutEntities = workoutService.getSortedWorkoutByDifficultyDesc();
        List<WorkoutDto> workoutDtos = new ArrayList<>();
        for (WorkoutEntity workout : workoutEntities) {
            workoutDtos.add(workoutConverter.toDto(workout));
        }
        return workoutDtos;
    }
}
