package org.spring2023.app.service.impl;

import lombok.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.spring2023.app.entity.UserEntity;
import org.spring2023.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

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
        var date1 = LocalDate.of(2003, Month.NOVEMBER, 13);
        userRepository.save(new UserEntity(1L, new ArrayList<>(), "Bot",
                "p@ssw0rd", "Uan", "Borisov", date1,
                "photo", "Moskow"));

        var date2 = LocalDate.of(2004, Month.NOVEMBER, 13);
        UserEntity newUser = new UserEntity(1L, new ArrayList<>(), "Bot2",
                "p@ssw0rd2", "Uan2", "Borisov2", date2,
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

    @Test
    @DisplayName("Get By City User Test")
    @DirtiesContext(classMode = AFTER_EACH_TEST_METHOD)
    void getUserByCity() {
        userRepository.save(new UserEntity(1L, new ArrayList<>(), "Bot",
                "p@ssw0rd", "Uan", "Borisov",
                LocalDate.of(2003, Month.NOVEMBER, 13), "photo", "Moscow"));
        userRepository.save(new UserEntity(2L, new ArrayList<>(), "Bot2",
                "p@ssw0rd2", "Uan2", "Borisov2",
                LocalDate.of(2003, Month.NOVEMBER, 13), "photo2", "Moscow"));
        userRepository.save(new UserEntity(3L, new ArrayList<>(), "Bot3",
                "p@ssw0rd3", "Uan3", "Borisov3",
                LocalDate.of(2003, Month.NOVEMBER, 13), "photo3", "Ekb"));

        List<UserEntity> usersByCity = userService.getUserByCity("Moscow");

        if (usersByCity.size() == 2) {
            for (UserEntity user : usersByCity) {
                assertEquals("Moscow", user.getCity());
            }
        } else {
            throw new RuntimeException();
        }
    }

    @Test
    @DisplayName("Get Sorted User By Birth Date Asc")
    @DirtiesContext(classMode = AFTER_EACH_TEST_METHOD)
    void getSortedUserByBirthDateAsc() {
        userRepository.save(new UserEntity(1L, new ArrayList<>(), "Bot",
                "p@ssw0rd", "Uan", "Borisov",
                LocalDate.of(2009, Month.NOVEMBER, 9), "photo", "Moscow"));

        userRepository.save(new UserEntity(2L, new ArrayList<>(), "Bot2",
                "p@ssw0rd2", "Uan2", "Borisov2",
                LocalDate.of(2005, Month.NOVEMBER, 5), "photo2", "Moscow"));

        userRepository.save(new UserEntity(3L, new ArrayList<>(), "Bot3",
                "p@ssw0rd3", "Uan3", "Borisov3",
                LocalDate.of(2004, Month.NOVEMBER, 4), "photo3", "Ekb"));
        List<UserEntity> sortedUsers = userService.getSortedUserByBirthDateAsc();
        for (UserEntity user : sortedUsers) {
            System.out.println(user.getName());
        }
        assertEquals("Uan3", sortedUsers.get(0).getName());
        assertEquals("Uan2", sortedUsers.get(1).getName());
        assertEquals("Uan", sortedUsers.get(2).getName());
    }

    @Test
    @DisplayName("Get Sorted User By Birth Date Desc")
    @DirtiesContext(classMode = AFTER_EACH_TEST_METHOD)
    void getSortedUserByBirthDateDesc() {
        userRepository.save(new UserEntity(1L, new ArrayList<>(), "Bot",
                "p@ssw0rd", "Uan", "Borisov",
                LocalDate.of(2009, Month.NOVEMBER, 9), "photo", "Moscow"));

        userRepository.save(new UserEntity(2L, new ArrayList<>(), "Bot2",
                "p@ssw0rd2", "Uan2", "Borisov2",
                LocalDate.of(2005, Month.NOVEMBER, 5), "photo2", "Moscow"));

        userRepository.save(new UserEntity(3L, new ArrayList<>(), "Bot3",
                "p@ssw0rd3", "Uan3", "Borisov3",
                LocalDate.of(2004, Month.NOVEMBER, 4), "photo3", "Ekb"));

        List<UserEntity> sortedUsers = userService.getSortedUserByBirthDateAsc();
        assertEquals("Uan", sortedUsers.get(2).getName());
        assertEquals("Uan2", sortedUsers.get(1).getName());
        assertEquals("Uan3", sortedUsers.get(0).getName());
    }
}