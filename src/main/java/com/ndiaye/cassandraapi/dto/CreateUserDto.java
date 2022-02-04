package com.ndiaye.cassandraapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDto {

    private String firstname;
    private String lastname;
    private String email;
    private String country;
    private int age;
}
