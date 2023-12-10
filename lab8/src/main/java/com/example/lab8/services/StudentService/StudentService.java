package com.example.lab8.services.StudentService;

import com.example.lab8.dto.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudents();

    List<StudentDto> getAllStudentsNoAttachment();
}
