package org.spring2023.app.service.impl;

import lombok.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.spring2023.app.entity.UserEntity;
import org.spring2023.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
@Data
class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Test
    @DisplayName("Create User Test")
    @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
    void saveUser() {
        UserEntity expected = (UserEntity) userService.saveUser(new UserEntity(1L, "Bot1",
                "p@ssw0rd", "Uan", "Borisov", "11/11/2011",
                "photo", "Moskow"));
        assertNotNull(expected);
        assertEquals("Uan", expected.getName());
    }

    @Test
    @DisplayName("Delete User Test")
    @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
    void deleteUser() {
        userService.saveUser(new UserEntity(1L, "Bot2",
                "p@ssw0rd2", "Uan2", "Borisov2", "11/11/20112",
                "photo2", "Moskow2"));
        userService.deleteUser(1L);
        List<UserEntity> expected = new ArrayList<>();
        assertEquals(expected, userService.findAllUsers());
    }

    @Test
    @DisplayName("Find All Users Test")
    @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
    void findAllUsers() {
        userService.saveUser(new UserEntity(1L, "Bot3",
                "p@ssw0rd3", "Uan3", "Borisov3", "11/11/20113",
                "photo3", "Moskow3"));
        System.out.println(userService.findById(1L).get().getUsername());
        List<UserEntity> expected = new ArrayList<>();
        expected.add(new UserEntity(1L, "Bot3",
                "p@ssw0rd3", "Uan3", "Borisov3", "11/11/20113",
                "photo3", "Moskow3"));
        assertEquals(expected, userService.findAllUsers());
    }

    @Test
    @DisplayName("Find By Id User Test")
    @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
    void findById() {
        userService.saveUser(new UserEntity(1L, "Bot4",
                "p@ssw0rd4", "Uan4", "Borisov4", "11/11/20114",
                "photo4", "Moskow4"));
        var actual = userService.findById(1L).get().getUsername();
        System.out.println(actual);
        assertEquals("Bot4", actual);
    }
}