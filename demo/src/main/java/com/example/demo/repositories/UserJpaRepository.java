package com.example.demo.repositories;

import com.example.demo.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class UserJpaRepository {
    @PersistenceContext
    private EntityManager entityManager;

}

//This seems to have no use at all...

