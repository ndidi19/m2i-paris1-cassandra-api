package com.ndiaye.cassandraapi.service.impl;

import com.ndiaye.cassandraapi.dto.CreateUserDto;
import com.ndiaye.cassandraapi.dto.UpdateUserDto;
import com.ndiaye.cassandraapi.dto.UserDto;
import com.ndiaye.cassandraapi.entity.User;
import com.ndiaye.cassandraapi.exception.UserNotFoundException;
import com.ndiaye.cassandraapi.repository.UserRepository;
import com.ndiaye.cassandraapi.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private static final String USER_NOT_FOUND_MSG = "User not found for id : ";

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> userList = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        for (User u : userList) {
            userDtoList.add(mapUserToUserDto(u));
        }
        return userDtoList;
    }

    @Override
    public UserDto createUser(CreateUserDto createUserDto) {
        User u = userRepository.save(mapCreateUserDtoToUser(createUserDto));
        return mapUserToUserDto(u);
    }

    @Override
    public UserDto getUserById(UUID id) {
        User u = retrieveUser(id);
        return mapUserToUserDto(u);
    }

    @Override
    public UserDto updateUser(UUID id, UpdateUserDto updateUserDto) {
        User u = retrieveUser(id);
        u.setEmail(updateUserDto.getEmail());
        u.setCountry(updateUserDto.getCountry());
        u.setAge(updateUserDto.getAge());
        userRepository.save(u);
        return mapUserToUserDto(u);
    }

    @Override
    public void deleteUserById(UUID id) {
        User u = retrieveUser(id);
        userRepository.delete(u);
    }

    @Override
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    private UserDto mapUserToUserDto(User u) {
        return new UserDto(
            u.getId(),
            u.getFirstname(),
            u.getLastname(),
            u.getEmail(),
            u.getCountry(),
            u.getAge()
        );
    }

    private User mapCreateUserDtoToUser(CreateUserDto u) {
        return new User(
                u.getFirstname(),
                u.getLastname(),
                u.getEmail(),
                u.getCountry(),
                u.getAge()
        );
    }

    private User retrieveUser(UUID id) {
        return userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException(USER_NOT_FOUND_MSG + id)
        );
    }
}
