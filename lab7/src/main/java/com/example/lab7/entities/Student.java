package com.example.lab7.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @UuidGenerator
    String id;
//    @JsonView
    String name;
//    @JsonView
    String surname;
//    @JsonView
    Float average;
}
