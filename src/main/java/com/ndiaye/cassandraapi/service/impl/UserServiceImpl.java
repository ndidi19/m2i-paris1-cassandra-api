package com.ndiaye.cassandraapi.service.impl;

import com.ndiaye.cassandraapi.dto.CreateUserDto;
import com.ndiaye.cassandraapi.dto.UserDto;
import com.ndiaye.cassandraapi.entity.User;
import com.ndiaye.cassandraapi.repository.UserRepository;
import com.ndiaye.cassandraapi.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

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
}
