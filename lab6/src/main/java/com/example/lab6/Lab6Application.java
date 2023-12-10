package com.example.lab6;

import com.example.lab6.entity.User;
import com.example.lab6.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Lab6Application {
    @Autowired
    private UserRepository dao;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(Lab6Application.class, args);
    }

    @PostConstruct
    public void init() {
//        dao.save(new User(
//                "Piotr",
//                "Piotrowski",
//                "admin",
//                passwordEncoder.encode("admin")
//        ));
//        dao.save(new User(
//                "Ania",
//                "Annowska",
//                "ania",
//                passwordEncoder.encode("ania")
//        ));
    }


}
