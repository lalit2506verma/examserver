package com.exam.service;

import com.exam.entity.User;
import com.exam.entity.UserRole;
import org.springframework.context.annotation.Bean;

import java.util.Set;

public interface UserService {

    //Creating User
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

}
