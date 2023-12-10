package com.example.lab7.services.StudentService;

import com.example.lab7.entities.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudentList();

    void addStudent(Student student);
}
