package org.spring2023.app.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.spring2023.app.entity.UserEntity;
import org.spring2023.app.repository.UserRepository;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
@ExtendWith(MockitoExtension.class)
public class UserServiceImplMockTest {
    @InjectMocks
    private UserServiceImpl userService;
    @Mock
    private UserRepository userRepository;

    @Test
    void getUsernamesAndPasswordsTest() {
        UserEntity user1 = new UserEntity(1L, new ArrayList<>(), "Bot",
                "p@ssw0rd", "Uan", "Borisov",
                LocalDate.of(2003, Month.NOVEMBER, 13), "photo", "Moscow");
        UserEntity user2 = new UserEntity(2L, new ArrayList<>(), "Bot2",
                "p@ssw0rd2", "Uan2", "Borisov2",
                LocalDate.of(2003, Month.NOVEMBER, 13), "photo2", "Moscow");
        UserEntity user3 = new UserEntity(3L, new ArrayList<>(), "Bot3",
                "p@ssw0rd3", "Uan3", "Borisov3",
                LocalDate.of(2003, Month.NOVEMBER, 13), "photo3", "Ekb");

        Mockito.when(userRepository.findAll()).thenReturn(List.of(user1, user2, user3));

        String users = userService.getUsernamesAndPasswords();

        Assertions.assertEquals("Bot-p@ssw0rd|Bot2-p@ssw0rd2|Bot3-p@ssw0rd3", users);
    }
}
