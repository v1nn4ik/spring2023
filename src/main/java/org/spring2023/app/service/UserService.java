package org.spring2023.app.service;

import org.spring2023.app.entity.UserEntity;
import org.spring2023.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(UserEntity user);
    void deleteUser(Long id);
    List<UserEntity> findAllUsers();
    Optional<UserEntity> findById(Long id);
}
