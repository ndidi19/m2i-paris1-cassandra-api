package com.ndiaye.cassandraapi.service;

import com.ndiaye.cassandraapi.dto.CreateUserDto;
import com.ndiaye.cassandraapi.dto.UpdateUserDto;
import com.ndiaye.cassandraapi.dto.UserDto;

import java.util.List;
import java.util.UUID;

public interface UserService {

    List<UserDto> getAllUsers();

    UserDto createUser(CreateUserDto createUserDto);

    UserDto getUserById(UUID id);

    UserDto updateUser(UUID id, UpdateUserDto updateUserDto);

    void deleteUserById(UUID id);

    void deleteAllUsers();
}
