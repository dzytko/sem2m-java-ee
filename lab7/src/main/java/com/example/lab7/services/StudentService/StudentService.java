package com.example.lab7.services.StudentService;

import com.example.lab7.entities.Student;
import com.example.lab7.exceptions.NotFoundException;

import java.util.List;

public interface StudentService {
    List<Student> getStudentList();

    Student getById(String id) throws NotFoundException;

    void addStudent(Student student);

    void deleteStudent(String id) throws NotFoundException;

    void updateStudent(Student student) throws NotFoundException;
}
