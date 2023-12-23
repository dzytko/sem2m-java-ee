package com.example.lab7.dtos.requests;

import lombok.Data;

@Data
public class EditStudentRequest {
    String id;
    String name;
    String surname;
    String average;
}
