package org.spring2023.domain;

import java.time.Duration;

/**
 * Интерфейс с упражнениями
 */
public interface Exercise {
    /**
     * Название упражнения
     * @return возвращает название упражнения
     */
    String getName();

    /**
     * Тип упражнения (силовые, кардио, растяжка, укрепление мышц и т.д.)
     * @return возвращает тип упражнения
     */
    String getType();

    /**
     * Сложность упражнения (от 0 до 5)
     * @return возвращает сложность упражнения
     */
    Difficulty getDifficulty();

    /**
     * Длительность упражнения
     * @return возвращает длительность упражнения
     */
    Duration getDuration();

    /**
     * Количество подходов в упражнении
     * @return возвращает количество подходов в упражнении
     */
    int getApproaches();

    /**
     * Необходимый инвентарь для упражнения
     * @return возвращает инвентарь для упражнения
     */
    String getEquipment();
}


