package org.spring2023.app.service;

import org.spring2023.app.entity.UserEntity;
import org.spring2023.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    /**
     * Функция сохранения пользователя
     * @param user пользователь
     */
    User saveUser(UserEntity user);

    /**
     * Функция удаления пользователя
     * @param id уникальный идентификатор пользователя
     */
    void deleteUser(Long id);

    /**
     * Функция получения всех пользователей
     * @return возвращает лист со всеми пользователями
     */
    List<UserEntity> findAllUsers();

    /**
     * Функция поиска пользователя по уникальному идентификатору
     * @param id уникальный идентификатор пользователя
     * @return возвращает пользователя
     */
    Optional<UserEntity> findById(Long id);
}
