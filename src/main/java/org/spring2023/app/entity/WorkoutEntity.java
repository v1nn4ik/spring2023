package org.spring2023.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.spring2023.domain.Difficulty;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "workouts")
public class WorkoutEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workout_id")
    private Long id;

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workout")
    private List<ExerciseEntity> exercises;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(name = "equipment")
    private String equipment;

    @Column(name = "progress")
    private int progress;

    @Column(name = "photo")
    private String photo;

    @Column(name = "note")
    private String note;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "location")
    private String location;
}