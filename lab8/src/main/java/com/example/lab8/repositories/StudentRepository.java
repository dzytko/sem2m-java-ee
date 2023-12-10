package com.example.lab8.repositories;

import com.example.lab8.dto.StudentDto;
import com.example.lab8.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT new com.example.lab8.dto.StudentDto(" +
            "s.name, s.surname, s.age, s.address.street, s.address.city, s.address.state, s.address.zip" +
            ") FROM Student s")
    List<StudentDto> findAllNoAttachment();
}
