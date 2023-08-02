package com.example.demo.controller;

import com.example.demo.models.User;
import com.example.demo.repositories.UserDataJpa;
import com.example.demo.repositories.UserJpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserJpaController {
    private UserDataJpa repository;

    public UserJpaController(UserDataJpa repository) {
        this.repository = repository;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers()
    {
        return repository.findAll();
    }
}
