package org.spring2023.extern.dto;

import lombok.Data;
import org.spring2023.domain.Difficulty;

import java.time.Duration;
import java.time.LocalDate;

@Data
public class WorkoutDto {
    String owner;
    String name;
    String type;
    String purpose;
    Difficulty difficulty;
    Duration duration;
    int approaches;
    String equipment;
    int progress;
    String photo;
    String note;
    LocalDate date;
    String location;
}
