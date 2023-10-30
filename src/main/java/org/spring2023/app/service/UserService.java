package org.spring2023.app.service;

import org.spring2023.app.entity.UserEntity;

public interface UserService {
    /**
     * Функция обновления пользователя
     * @param user пользователь
     * @param id уникальный идентификатор пользователя
     * @return возвращает обновленного пользователя
     */
    UserEntity update(UserEntity user, Long id);
}
