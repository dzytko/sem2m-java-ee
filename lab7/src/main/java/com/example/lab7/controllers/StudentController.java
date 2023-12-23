package com.example.lab7.controllers;

import com.example.lab7.dtos.requests.CreateStudentRequest;
import com.example.lab7.dtos.requests.EditStudentRequest;
import com.example.lab7.entities.Student;
import com.example.lab7.exceptions.BadRequestException;
import com.example.lab7.exceptions.NotFoundException;
import com.example.lab7.services.StudentService.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAll() {
        return new ResponseEntity<>(studentService.getStudentList(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable String id) throws NotFoundException {
        return new ResponseEntity<>(studentService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody CreateStudentRequest request) throws BadRequestException {
        Student student;
        try {
            student = Student.builder()
                    .name(request.getName())
                    .surname(request.getSurname())
                    .average(Float.parseFloat(request.getAverage()))
                    .build();
        } catch (NumberFormatException e) {
            throw new BadRequestException("Average must be a number");
        }
        studentService.addStudent(student);

        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Student> updateStudent(@RequestBody EditStudentRequest request) throws NotFoundException, BadRequestException {
        Student student;
        try {
            student = Student.builder()
                    .id(request.getId())
                    .name(request.getName())
                    .surname(request.getSurname())
                    .average(Float.parseFloat(request.getAverage()))
                    .build();
        } catch (NumberFormatException e) {
            throw new BadRequestException("Average must be a number");
        }

        studentService.updateStudent(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteStudent(@PathVariable String id) throws NotFoundException {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }
}
