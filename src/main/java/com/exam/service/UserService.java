package com.exam.service;

import com.exam.entity.User;
import com.exam.entity.UserRole;
import org.springframework.context.annotation.Bean;

import java.util.Set;

public interface UserService {

    //Creating User
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    //updating User Details
    public User updateUser(String username, User user) throws Exception;

    //getting User
    public User getUser(String username);

    // Getting User by User ID
    public User getUserById(Long userId);

    //delete User by userId
    public void deleteUserById(Long userId);

}
