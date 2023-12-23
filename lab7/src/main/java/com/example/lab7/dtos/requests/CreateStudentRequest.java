package com.example.lab7.dtos.requests;

import lombok.Data;

@Data
public class CreateStudentRequest {
    String name;
    String surname;
    String average;
}
