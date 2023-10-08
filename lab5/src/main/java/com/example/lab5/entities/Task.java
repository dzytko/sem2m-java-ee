package com.example.lab5.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;

@Entity
@Data
public class Task {
    @GeneratedValue
    @Id
    private Long id;

    private String name;

    @Lob
    private String description;

    private Double cost;

    private Boolean done;
}
