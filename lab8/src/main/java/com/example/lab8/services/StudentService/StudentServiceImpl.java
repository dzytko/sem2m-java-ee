package com.example.lab8.services.StudentService;

import com.example.lab8.converters.StudentConverter;
import com.example.lab8.dto.StudentDto;
import com.example.lab8.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentConverter studentConverter;

    @Override
    public List<StudentDto> getAllStudents() {
        var students = studentRepository.findAll();
        return students
                .stream()
                .map(studentConverter::convert)
                .collect(Collectors.toList());
    }
}
