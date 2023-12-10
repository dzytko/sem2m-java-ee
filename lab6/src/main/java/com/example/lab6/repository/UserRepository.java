package com.example.lab6.repository;

import com.example.lab6.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByLogin(String login);
}
