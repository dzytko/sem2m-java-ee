package com.example.lab8.mappers;

import com.example.lab8.dto.StudentDto;
import com.example.lab8.entities.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface StudentMapper {
    @Mapping(target = "street", source = "student.address.street")
    @Mapping(target = "city", source = "student.address.city")
    @Mapping(target = "state", source = "student.address.state")
    @Mapping(target = "zip", source = "student.address.zip")
    StudentDto mapStudentToStudentDto(Student student);
}
