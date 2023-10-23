package org.spring2023.app.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.spring2023.app.entity.UserEntity;
import org.spring2023.app.UserRepository;
import org.spring2023.app.service.UserService;
import org.spring2023.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User saveUser(UserEntity user) {
        log.info("\nНовый пользователь добавлен");
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        log.info("\nПользователь №" + id + " удален");
        userRepository.deleteById(id);
    }

    @Override
    public List<UserEntity> findAllUsers() {
        log.info("\nЗапрос на вывод всех пользователей выполнен");
        return (List<UserEntity>) userRepository.findAll();
    }

    @Override
    public Optional<UserEntity> findById(Long id) {
        log.info("\nПользователь №" + id + " выведен");
        return userRepository.findById(id);
    }
}
