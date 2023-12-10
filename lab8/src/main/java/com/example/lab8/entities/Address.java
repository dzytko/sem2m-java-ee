package com.example.lab8.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String street;
    String city;
    String state;
    String zip;

    @OneToOne(mappedBy = "address")
    Student student;
}
