package com.ndiaye.cassandraapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private UUID id;
    private String firstname;
    private String lastname;
    private String email;
    private String country;
    private int age;
}
