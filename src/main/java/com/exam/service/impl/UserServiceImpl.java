package com.exam.service.impl;

import com.exam.entity.User;
import com.exam.entity.UserRole;
import com.exam.repo.RoleRepository;
import com.exam.repo.UserRepository;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    //-Function to create user
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {

        User local = this.userRepository.findByUsername(user.getUsername());

        // check username exists or not
        if(local != null){
            System.out.println("User with this username is already exists");
            throw new Exception("This username already exists");
        }
        else {
            //User will create

            //First of all UserRoles have many roles so we take every role one by one then save it in roles table
            for(UserRole ur:userRoles){
                this.roleRepository.save(ur.getRole());
            }

            user.getUserRole().addAll(userRoles);
            User Local = this.userRepository.save(user);

        }

        return local;
    }
}
