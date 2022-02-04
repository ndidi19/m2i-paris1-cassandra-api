package com.ndiaye.cassandraapi.service;

import com.ndiaye.cassandraapi.dto.CreateUserDto;
import com.ndiaye.cassandraapi.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getAllUsers();

    UserDto createUser(CreateUserDto createUserDto);
}
