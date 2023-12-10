package com.example.lab7.services.StudentService;

import com.example.lab7.entities.Student;
import com.example.lab7.exceptions.NotFoundException;
import com.example.lab7.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getStudentList() {
        return studentRepository.findAll();
    }

    @Override
    public Student getById(String id) throws NotFoundException {
        return studentRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Student with id " + id + " not found"));
    }

    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(String id) throws NotFoundException {
        if (studentRepository.findById(id).isEmpty()) {
            throw new NotFoundException("Student with id " + id + " not found");
        }
        studentRepository.deleteById(id);
    }

    @Override
    public void updateStudent(Student student) throws NotFoundException {
        if (studentRepository.findById(student.getId()).isEmpty()) {
            throw new NotFoundException("Student with id " + student.getId() + " not found");
        }
        studentRepository.save(student);
    }
}
