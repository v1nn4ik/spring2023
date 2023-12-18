package org.spring2023.app.entity;

import jakarta.persistence.*;
import lombok.*;
import org.spring2023.domain.User;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserEntity implements User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<WorkoutEntity> workouts;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "photo")
    private String photo;

    @Column(name = "city")
    private String city;
}
