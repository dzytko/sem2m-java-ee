package com.example.lab10.repositories;

import com.example.lab10.entities.UserDao;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserDao, Long> {
    UserDao findByUsername(String username);
}
