package org.spring2023.app.service.impl;

import lombok.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.spring2023.app.entity.UserEntity;
import org.spring2023.app.entity.WorkoutEntity;
import org.spring2023.app.service.repository.WorkoutRepository;
import org.spring2023.domain.Difficulty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;

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
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.NOVEMBER, 6, 19, 38, 27);
        workoutRepository.save(new WorkoutEntity(1L, "T1", "type",
                "purpose", Difficulty.ELEMENTARY, Duration.ofMinutes(1), 0, new ArrayList<>(), new UserEntity(),
                "equipment", 0, "photo", "note", calendar, "location"));

        WorkoutEntity newWorkout = new WorkoutEntity(1L, "T2", "type2",
                "purpose2", Difficulty.ELEMENTARY, Duration.ofMinutes(1), 1, new ArrayList<>(), new UserEntity(),
                "equipment2",1, "photo2", "note2", calendar, "location2");

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
}