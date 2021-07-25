package com.orgustine.todo.repositories;

import com.orgustine.todo.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByEmailAndPassword(String email, String password);
}
