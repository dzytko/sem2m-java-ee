package com.example.lab8.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String name;
    String surname;
    Integer age;

    @Lob
    byte[] attachment;

    @JoinColumn(name = "address_id")
    @OneToOne(cascade = CascadeType.ALL)
    Address address;
}
