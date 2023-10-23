/**
 * Временно закомментировал, так как не доделал, а тесты и прочее не работают

package org.spring2023.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private int difficulty;

    @Column(name = "duration")
    private String duration;

    @Column(name = "approaches")
    private int approaches;

    @Column(name = "exercises")
    @OneToMany(mappedBy = "workout")
    private List<ExerciseEntity> exercises;

    @Column(name = "equipment")
    private String equipment;

    @Column(name = "progress")
    private int progress;

    @Column(name = "photo")
    private String photo;

    @Column(name = "note")
    private String note;

    @Column(name = "date")
    private String date;

    @Column(name = "time")
    private String time;

    @Column(name = "location")
    private String location;
}
 */