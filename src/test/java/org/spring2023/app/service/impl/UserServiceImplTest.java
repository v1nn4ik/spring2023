package org.spring2023.app.service.impl;

import lombok.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.spring2023.app.entity.UserEntity;
import org.spring2023.app.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.Calendar;

import static junit.framework.Assert.assertEquals;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD;

@SpringBootTest
@AutoConfigureTestDatabase
@Data
class UserServiceImplTest {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("Update User Test")
    @DirtiesContext(classMode = AFTER_EACH_TEST_METHOD)
    void update() {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(2003, Calendar.NOVEMBER, 6, 19, 38, 27);
        userRepository.save(new UserEntity(1L, new ArrayList<>(), "Bot",
                "p@ssw0rd", "Uan", "Borisov", calendar1,
                "photo", "Moskow"));

        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2004, Calendar.NOVEMBER, 6, 19, 38, 27);
        UserEntity newUser = new UserEntity(1L, new ArrayList<>(), "Bot2",
                "p@ssw0rd2", "Uan2", "Borisov2", calendar2,
                "photo2", "Moskow2");

        userService.update(newUser, 1L);

        if (userRepository.findById(1L).isPresent()) {
            UserEntity actual = userRepository.findById(1L).get();
            assertEquals(newUser.getUsername(), actual.getUsername());
            assertEquals(newUser.getPassword(), actual.getPassword());
            assertEquals(newUser.getName(), actual.getName());
            assertEquals(newUser.getSurname(), actual.getSurname());
            assertEquals(newUser.getBirthDate(), actual.getBirthDate());
            assertEquals(newUser.getPhoto(), actual.getPhoto());
            assertEquals(newUser.getCity(), actual.getCity());
        } else {
            throw new RuntimeException();
        }
    }


}