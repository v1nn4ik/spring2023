package org.spring2023.app.service;

import org.spring2023.app.entity.WorkoutEntity;

public interface WorkoutService {
    /**
     * Функция обновления тренировки
     * @param workoutEntity тренировка
     * @param id уникальный идентификатор тренировки
     * @return возвращает обновленную тренировку
     */
    WorkoutEntity update(WorkoutEntity workoutEntity, Long id);
}
