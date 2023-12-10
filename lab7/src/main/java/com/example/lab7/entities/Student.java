package com.example.lab7.entities;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Data
public class Student {
    @Id
    @UuidGenerator
    // TODO disable serialization
    String id;
//    @JsonView
    String name;
//    @JsonView
    String surname;
//    @JsonView
    Float average;
}
