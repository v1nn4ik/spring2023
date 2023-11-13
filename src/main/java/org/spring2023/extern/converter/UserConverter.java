package org.spring2023.extern.converter;

import org.spring2023.app.entity.UserEntity;
import org.spring2023.extern.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public UserDto toDto(UserEntity userEntity) {
        UserDto userDto = new UserDto();
        userDto.setUsername(userEntity.getUsername());
        userDto.setPassword(userEntity.getPassword());
        userDto.setName(userEntity.getName());
        userDto.setSurname(userEntity.getSurname());
        userDto.setBirthDate(userEntity.getBirthDate());
        userDto.setPhoto(userEntity.getPhoto());
        userDto.setCity(userEntity.getCity());
        return userDto;
    }
    public UserEntity toEntity(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userDto.getUsername());
        userEntity.setPassword(userDto.getPassword());
        userEntity.setName(userDto.getName());
        userEntity.setSurname(userDto.getSurname());
        userEntity.setBirthDate(userDto.getBirthDate());
        userEntity.setPhoto(userDto.getPhoto());
        userEntity.setCity(userDto.getCity());
        return userEntity;
    }
}
