package com.example.lab5.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Country {
    @GeneratedValue
    @Id
    private Long id;

    String name;
    String code;
    Integer population;
    Integer surfaceArea;
    String continent;
}
