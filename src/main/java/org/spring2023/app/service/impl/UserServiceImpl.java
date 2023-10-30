package org.spring2023.app.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.spring2023.app.entity.UserEntity;
import org.spring2023.app.service.repository.UserRepository;
import org.spring2023.app.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Override
    public UserEntity update(UserEntity userEntity, Long id) {
        Optional<UserEntity> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            UserEntity existUser = optionalUser.get();
            existUser.setUsername(userEntity.getUsername());
            existUser.setPassword(userEntity.getPassword());
            existUser.setName(userEntity.getName());
            existUser.setSurname(userEntity.getSurname());
            existUser.setBirthDate(userEntity.getBirthDate());
            existUser.setPhoto(userEntity.getPhoto());
            existUser.setCity(userEntity.getCity());
            log.info("\nПользователь №" + id + " изменен");
            return userRepository.save(existUser);
        } else {
            throw new RuntimeException("\nПользователь с №" + id + " не найден");
        }
    }
}
