package org.spring2023.extern.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDto {
    String username;
    String password;
    String name;
    String surname;
    LocalDate birthDate;
    String photo;
    String city;
}
