package org.spring2023.app.service.impl;

import lombok.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.spring2023.app.entity.UserEntity;
import org.spring2023.app.entity.WorkoutEntity;
import org.spring2023.app.service.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
@Data
class WorkoutServiceImplTest {
    @Autowired
    private WorkoutServiceImpl workoutService;
    @Autowired
    private WorkoutRepository workoutRepository;

    @Test
    @DisplayName("Update User Test")
    @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
    void update() {
        workoutRepository.save(new WorkoutEntity(1L, "T1", "type",
                "purpose", 0, "duration", 0, new ArrayList<>(), new UserEntity(),
                "equipment",0, "photo", "note", "date",
                "time", "location"));

        WorkoutEntity newWorkout = new WorkoutEntity(1L, "T2", "type2",
                "purpose2", 1, "duration2", 1, new ArrayList<>(), new UserEntity(),
                "equipment2",1, "photo2", "note2", "date2",
                "time2", "location2");
        String expected = "T2";

        workoutService.update(newWorkout, 1L);

        if (workoutRepository.findById(1L).isPresent()) {
            String actual = workoutRepository.findById(1L).get().getName();
            assertEquals(expected, actual);
        } else {
            throw new RuntimeException();
        }
    }
}