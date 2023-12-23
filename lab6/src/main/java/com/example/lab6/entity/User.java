package com.example.lab6.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userid;

    @NotBlank(message = "Pole jest wymagane")
    private String name;

    @NotBlank(message = "Pole jest wymagane")
    private String surname;

    @Size(min = 2, message = "Login musi mieć co najmniej {min} znaki")
    @NotBlank(message = "Pole jest wymagane")
    private String login;

    @NotBlank(message = "Pole jest wymagane")
    private String password;

    public User(String name, String surname, String login, String password) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
    }
}
