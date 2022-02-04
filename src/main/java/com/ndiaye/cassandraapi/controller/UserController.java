package com.ndiaye.cassandraapi.controller;

import com.ndiaye.cassandraapi.dto.CreateUserDto;
import com.ndiaye.cassandraapi.dto.UpdateUserDto;
import com.ndiaye.cassandraapi.dto.UserDto;
import com.ndiaye.cassandraapi.service.UserService;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public UserDto createUser(@Valid @RequestBody CreateUserDto createUserDto) {
        return userService.createUser(createUserDto);
    }

    @GetMapping("/users/{id}")
    public UserDto getUserById(@PathVariable UUID id) {
        return userService.getUserById(id);
    }

    @PutMapping("/users/{id}")
    public UserDto updateUserById(@PathVariable UUID id, @Valid @RequestBody UpdateUserDto updateUserDto) {
        return userService.updateUser(id, updateUserDto);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable UUID id) {
        userService.deleteUserById(id);
    }

    @ApiIgnore
    @DeleteMapping("/users")
    public void deleteAllUsers() {
        userService.deleteAllUsers();
    }
}
