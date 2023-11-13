package org.spring2023.extern.dto;

import lombok.Data;
import org.spring2023.domain.Difficulty;

import java.time.Duration;

@Data
public class ExerciseDto {
    String name;
    String type;
    String purpose;
    Difficulty difficulty;
    Duration duration;
    int approaches;
    String equipment;
}
