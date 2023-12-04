package org.spring2023.app.service.impl;

import lombok.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.spring2023.app.entity.UserEntity;
import org.spring2023.app.entity.WorkoutEntity;
import org.spring2023.app.repository.WorkoutRepository;
import org.spring2023.domain.Difficulty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD;

@SpringBootTest
@AutoConfigureTestDatabase
@Data
class WorkoutServiceImplTest {
    @Autowired
    private WorkoutServiceImpl workoutService;
    @Autowired
    private WorkoutRepository workoutRepository;

    @Test
    @DisplayName("Update Workout Test")
    @DirtiesContext(classMode = AFTER_EACH_TEST_METHOD)
    void update() {
        var date = LocalDate.of(2003, Month.NOVEMBER, 13);
        workoutRepository.save(new WorkoutEntity(1L, "T1", "type",
                "purpose", Difficulty.ELEMENTARY, Duration.ofMinutes(1), 0, new ArrayList<>(), new UserEntity(),
                "equipment", 0, "photo", "note", date, "location"));

        WorkoutEntity newWorkout = new WorkoutEntity(1L, "T2", "type2",
                "purpose2", Difficulty.ELEMENTARY, Duration.ofMinutes(1), 1, new ArrayList<>(), new UserEntity(),
                "equipment2",1, "photo2", "note2", date, "location2");

        workoutService.update(newWorkout, 1L);

        if (workoutRepository.findById(1L).isPresent()) {
            WorkoutEntity actual = workoutRepository.findById(1L).get();
            assertEquals(newWorkout.getName(), actual.getName());
            assertEquals(newWorkout.getType(), actual.getType());
            assertEquals(newWorkout.getPurpose(), actual.getPurpose());
            assertEquals(newWorkout.getDifficulty(), actual.getDifficulty());
            assertEquals(newWorkout.getDuration(), actual.getDuration());
            assertEquals(newWorkout.getApproaches(), actual.getApproaches());
            assertEquals(newWorkout.getEquipment(), actual.getEquipment());
            assertEquals(newWorkout.getPhoto(), actual.getPhoto());
            assertEquals(newWorkout.getNote(), actual.getNote());
            assertEquals(newWorkout.getDate(), actual.getDate());
            assertEquals(newWorkout.getLocation(), actual.getLocation());
        } else {
            throw new RuntimeException();
        }
    }
    @Test
    @DisplayName("Get By Difficulty Workout Test")
    @DirtiesContext(classMode = AFTER_EACH_TEST_METHOD)
    void getWorkoutByDifficulty() {
        var date = LocalDate.of(2003, Month.NOVEMBER, 13);
        workoutRepository.save(new WorkoutEntity(1L, "T1", "type",
                "purpose", Difficulty.ELEMENTARY, Duration.ofMinutes(1), 0, new ArrayList<>(), new UserEntity(),
                "equipment", 0, "photo", "note", date, "location"));
        workoutRepository.save(new WorkoutEntity(2L, "T2", "type",
                "purpose", Difficulty.ADVANCED, Duration.ofMinutes(1), 0, new ArrayList<>(), new UserEntity(),
                "equipment", 0, "photo", "note", date, "location"));
        workoutRepository.save(new WorkoutEntity(3L, "T3", "type",
                "purpose", Difficulty.MIDDLE, Duration.ofMinutes(1), 0, new ArrayList<>(), new UserEntity(),
                "equipment", 0, "photo", "note", date, "location"));
        workoutRepository.save(new WorkoutEntity(4L, "T3", "type",
                "purpose", Difficulty.MIDDLE, Duration.ofMinutes(1), 0, new ArrayList<>(), new UserEntity(),
                "equipment", 0, "photo", "note", date, "location"));
        workoutRepository.save(new WorkoutEntity(5L, "T1", "type",
                "purpose", Difficulty.ELEMENTARY, Duration.ofMinutes(1), 0, new ArrayList<>(), new UserEntity(),
                "equipment", 0, "photo", "note", date, "location"));
        List<WorkoutEntity> workoutsByDifficulty = workoutService.getWorkoutByDifficulty(Difficulty.MIDDLE);
        if (workoutsByDifficulty.size() == 2) {
            for (WorkoutEntity workout : workoutsByDifficulty) {
                assertEquals(Difficulty.MIDDLE, workout.getDifficulty());
            }
        } else {
            throw new RuntimeException();
        }
    }

    @Test
    @DisplayName("Get Sorted Workout By Difficulty Asc")
    @DirtiesContext(classMode = AFTER_EACH_TEST_METHOD)
    void getSortedWorkoutByDifficultyAsc() {
        var date = LocalDate.of(2003, Month.NOVEMBER, 13);
        workoutRepository.save(new WorkoutEntity(1L, "T1", "type",
                "purpose", Difficulty.ELEMENTARY, Duration.ofMinutes(1), 0, new ArrayList<>(), new UserEntity(),
                "equipment", 0, "photo", "note", date, "location"));
        workoutRepository.save(new WorkoutEntity(2L, "T2", "type",
                "purpose", Difficulty.ADVANCED, Duration.ofMinutes(1), 0, new ArrayList<>(), new UserEntity(),
                "equipment", 0, "photo", "note", date, "location"));
        workoutRepository.save(new WorkoutEntity(3L, "T3", "type",
                "purpose", Difficulty.MIDDLE, Duration.ofMinutes(1), 0, new ArrayList<>(), new UserEntity(),
                "equipment", 0, "photo", "note", date, "location"));
        workoutRepository.save(new WorkoutEntity(4L, "T4", "type",
                "purpose", Difficulty.MIDDLE, Duration.ofMinutes(1), 0, new ArrayList<>(), new UserEntity(),
                "equipment", 0, "photo", "note", date, "location"));
        workoutRepository.save(new WorkoutEntity(5L, "T5", "type",
                "purpose", Difficulty.ELEMENTARY, Duration.ofMinutes(1), 0, new ArrayList<>(), new UserEntity(),
                "equipment", 0, "photo", "note", date, "location"));
        List<WorkoutEntity> workoutByDifficulty = workoutService.getSortedWorkoutByDifficultyAsc();
        assertEquals("T1", workoutByDifficulty.get(0).getName());
        assertEquals("T5", workoutByDifficulty.get(1).getName());
        assertEquals("T3", workoutByDifficulty.get(2).getName());
        assertEquals("T4", workoutByDifficulty.get(3).getName());
        assertEquals("T2", workoutByDifficulty.get(4).getName());
    }

    @Test
    @DisplayName("Get Sorted Workout By Difficulty Desc")
    @DirtiesContext(classMode = AFTER_EACH_TEST_METHOD)
    void getSortedWorkoutByDifficultyDesc() {
        var date = LocalDate.of(2003, Month.NOVEMBER, 13);
        workoutRepository.save(new WorkoutEntity(1L, "T1", "type",
                "purpose", Difficulty.ELEMENTARY, Duration.ofMinutes(1), 0, new ArrayList<>(), new UserEntity(),
                "equipment", 0, "photo", "note", date, "location"));
        workoutRepository.save(new WorkoutEntity(2L, "T2", "type",
                "purpose", Difficulty.ADVANCED, Duration.ofMinutes(1), 0, new ArrayList<>(), new UserEntity(),
                "equipment", 0, "photo", "note", date, "location"));
        workoutRepository.save(new WorkoutEntity(3L, "T3", "type",
                "purpose", Difficulty.MIDDLE, Duration.ofMinutes(1), 0, new ArrayList<>(), new UserEntity(),
                "equipment", 0, "photo", "note", date, "location"));
        workoutRepository.save(new WorkoutEntity(4L, "T4", "type",
                "purpose", Difficulty.MIDDLE, Duration.ofMinutes(1), 0, new ArrayList<>(), new UserEntity(),
                "equipment", 0, "photo", "note", date, "location"));
        workoutRepository.save(new WorkoutEntity(5L, "T5", "type",
                "purpose", Difficulty.ELEMENTARY, Duration.ofMinutes(1), 0, new ArrayList<>(), new UserEntity(),
                "equipment", 0, "photo", "note", date, "location"));
        List<WorkoutEntity> workoutByDifficulty = workoutService.getSortedWorkoutByDifficultyDesc();
        assertEquals("T2", workoutByDifficulty.get(0).getName());
        assertEquals("T3", workoutByDifficulty.get(1).getName());
        assertEquals("T4", workoutByDifficulty.get(2).getName());
        assertEquals("T1", workoutByDifficulty.get(3).getName());
        assertEquals("T5", workoutByDifficulty.get(4).getName());
    }
}