package org.spring2023.extern.api;

import lombok.AllArgsConstructor;
import org.spring2023.app.service.impl.UserServiceImpl;
import org.spring2023.app.service.repository.UserRepository;
import org.spring2023.app.entity.UserEntity;
import org.spring2023.domain.User;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final UserServiceImpl userService;

    @PostMapping
    public User saveUser(@RequestBody UserEntity user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public UserEntity updateUser(@RequestBody UserEntity user, @PathVariable Long id) {
        return userService.update(user, id);
    }

    @GetMapping
    public Iterable<UserEntity> findAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<UserEntity> findById(@PathVariable("id") Long id) {
        return userRepository.findById(id);
    }
}
