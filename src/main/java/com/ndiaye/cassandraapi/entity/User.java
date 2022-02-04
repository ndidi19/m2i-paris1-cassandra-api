package com.ndiaye.cassandraapi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table
@Data
@NoArgsConstructor
public class User {

    @PrimaryKey
    private UUID id;
    private String firstname;
    private String lastname;
    private String email;
    private String country;
    private int age;

    public User(String firstname, String lastname, String email, String country, int age) {
        this.id = UUID.randomUUID();
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.country = country;
        this.age = age;
    }
}
