package org.spring2023.app.service.impl;

import lombok.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.spring2023.app.entity.UserEntity;
import org.spring2023.app.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;

@SpringBootTest
@AutoConfigureTestDatabase
@Data
class UserServiceImplTest {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("Delete User Test")
    @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
    void update() {
        userRepository.save(new UserEntity(1L, new ArrayList<>(), "Bot",
                "p@ssw0rd", "Uan", "Borisov", "11/11/2011",
                "photo", "Moskow"));

        UserEntity newUser = new UserEntity(1L, new ArrayList<>(), "Bot2",
                "p@ssw0rd2", "Uan2", "Borisov2", "11/11/20112",
                "photo2", "Moskow2");
        String expected = "Bot2";

        userService.update(newUser, 1L);

        if (userRepository.findById(1L).isPresent()) {
            String actual = userRepository.findById(1L).get().getUsername();
            Assertions.assertEquals(expected, actual);
        } else {
            throw new RuntimeException();
        }
    }


}