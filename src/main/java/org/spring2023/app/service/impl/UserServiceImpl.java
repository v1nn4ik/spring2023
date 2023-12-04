package org.spring2023.app.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.spring2023.app.entity.UserEntity;
import org.spring2023.app.repository.UserRepository;
import org.spring2023.app.service.UserService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Override
    public UserEntity update(UserEntity userEntity, Long id) {
        return userRepository.findById(id).map(user -> {
            user.setUsername(userEntity.getUsername());
            user.setPassword(userEntity.getPassword());
            user.setName(userEntity.getName());
            user.setSurname(userEntity.getSurname());
            user.setBirthDate(userEntity.getBirthDate());
            user.setPhoto(userEntity.getPhoto());
            user.setCity(userEntity.getCity());
            log.info("\nПользователь №" + id + " изменен");
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("\nПользователь с №" + id + " не найден"));
    }

    public List<UserEntity> getUserByCity(String city) {
        return userRepository.findByCityIgnoreCase(city);
    }

    public List<UserEntity> getSortedUserByBirthDateAsc() {
        return userRepository.findAll(Sort.by(Sort.Direction.ASC, "city"));
    }

    public List<UserEntity> getSortedUserByBirthDateDesc() {
        return userRepository.findAll(Sort.by(Sort.Direction.DESC, "city"));
    }
}
