package com.exam.repo;

import com.exam.entity.User;
import com.exam.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
