package com.ndiaye.cassandraapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserDto {

    @NotEmpty(message = "Should not be empty")
    private String email;
    @NotEmpty(message = "Should not be empty")
    private String country;
    @Min(value = 18, message = "Should be greater than or equal to 18")
    @Max(value = 150, message = "Should be lower than or equal to 150")
    private int age;
}
