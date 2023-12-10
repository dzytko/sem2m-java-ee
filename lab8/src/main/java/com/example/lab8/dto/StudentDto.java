package com.example.lab8.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentDto {
    String name;
    String surname;
    Integer age;
    String street;
    String city;
    String zip;
    String state;
}
