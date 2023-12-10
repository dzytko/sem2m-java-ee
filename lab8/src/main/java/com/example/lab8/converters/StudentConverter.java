package com.example.lab8.converters;

import com.example.lab8.dto.StudentDto;
import com.example.lab8.entities.Student;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StudentConverter implements Converter<Student, StudentDto> {
    @Override
    public StudentDto convert(Student source) {
        return StudentDto.builder()
                .name(source.getName())
                .surname(source.getSurname())
                .age(source.getAge())
                .street(source.getAddress().getStreet())
                .city(source.getAddress().getCity())
                .zip(source.getAddress().getZip())
                .state(source.getAddress().getState())
                .build();
    }
}
