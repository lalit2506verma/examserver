package com.exam.controller;

import com.exam.entity.Role;
import com.exam.entity.User;
import com.exam.entity.UserRole;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //Create normal user with normal access and roles
    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {

        Set<UserRole> roles = new HashSet<>();

        // User is prefined using this API user will created and normal access is provide
        Role role = new Role();
        role.setRoleId(12L);
        role.setRoleName("BASIC_ACCESS");
        role.setRole_Description("Basic user Access");

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        roles.add(userRole);

        return this.userService.createUser(user,roles);
    }

    //Update the user Details
    @PostMapping("/{username}")
    public User updateUser(@PathVariable("username") String username, @RequestBody User user) throws Exception {
        return this.userService.updateUser(username, user);
    }

    //Fetch user from username
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username) throws Exception {

        return this.userService.getUser(username);
    }

    //Get user by UserID
    @GetMapping("/{userId}/")
    public User getUserById(@PathVariable("userId") Long userId){
        return this.userService.getUserById(userId);
    }

    //Delete User by UserId
    @DeleteMapping("/{userId}")
    public void deleteUserById(@PathVariable("userId") Long userId){
        this.userService.deleteUserById(userId);
    }
}
