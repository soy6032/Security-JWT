package com.project.jpa1.repository;

import com.project.jpa1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // select * from user where username = ?
    Optional<User> findByUsername(String username); // Jpa NameQuery 작동
    // save - 이미 만들어져 있음.
}
