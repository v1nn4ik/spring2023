package org.spring2023.domain;

public interface User { //Профиль пользователя в приложении с данными для входа
    String getUsername(); //Логин
    String getPassword(); //Пароль
    String getName(); //Имя
    String getSurname(); //Фамилия
    String getBirthDate(); //Дата рождения
    String getPhoto(); //Фотография
    String getCity(); //Город
}
