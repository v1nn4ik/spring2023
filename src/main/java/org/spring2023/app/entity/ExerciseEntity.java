package org.spring2023.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.spring2023.domain.Difficulty;
import org.spring2023.domain.Exercise;

import java.time.Duration;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "exercises")
public class ExerciseEntity implements Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exercise_id")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "workout_id")
    private WorkoutEntity workout;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "purpose")
    private String purpose;

    @Column(name = "difficulty")
    private Difficulty difficulty;

    @Column(name = "duration")
    private Duration duration;

    @Column(name = "approaches")
    private int approaches;

    @Column(name = "equipment")
    private String equipment;
}
