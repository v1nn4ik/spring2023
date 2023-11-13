package org.spring2023.extern.api;

import lombok.AllArgsConstructor;
import org.spring2023.app.service.impl.UserServiceImpl;
import org.spring2023.app.repository.UserRepository;
import org.spring2023.app.entity.UserEntity;
import org.spring2023.extern.converter.UserConverter;
import org.spring2023.extern.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final UserServiceImpl userService;
    private final UserConverter userConverter;

    @PostMapping
    public UserDto saveUser(@RequestBody UserDto userDto) {
        UserEntity userEntity = userConverter.toEntity(userDto);
        return userConverter.toDto(userRepository.save(userEntity));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public UserDto updateUser(@RequestBody UserDto userDto, @PathVariable Long id) {
        UserEntity userEntity = userConverter.toEntity(userDto);
        return userConverter.toDto(userService.update(userEntity, id));
    }

    @GetMapping
    public List<UserDto> findAllUsers() {
        Iterable<UserEntity> userEntities = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        for (UserEntity user : userEntities) {
            userDtos.add(userConverter.toDto(user));
        }
        return userDtos;
    }

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable("id") Long id) {
        return userConverter.toDto(userRepository.findById(id).get());
    }
}
