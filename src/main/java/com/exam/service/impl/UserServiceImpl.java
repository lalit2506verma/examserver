package com.exam.service.impl;

import com.exam.entity.User;
import com.exam.entity.UserRole;
import com.exam.repo.RoleRepository;
import com.exam.repo.UserRepository;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
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
            throw new Exception("This username already exists!!");
        }
        else {
            //User will create

            //First of all UserRoles have many roles so we take every role one by one then save it in roles table
            for(UserRole ur:userRoles){
                this.roleRepository.save(ur.getRole());
                System.out.println("This line runs");
            }

            user.getUserRole().addAll(userRoles);
            System.out.println("This code runs");
            local = this.userRepository.save(user);

        }

        return local;
    }

    //Update the User Details i.e Email, phoneNumber, First Name, Last Name, Gender
    @Override
    public User updateUser(String username, User user) throws Exception {
        System.out.println(username);
        User local = this.userRepository.findByUsername(username);

        if(local != null){
            System.out.println("User does not exist in the database with this username");
            throw new Exception("User does not exists");
        }
        else {
            local.setEmail(user.getEmail());
            local.setPhoneNumber(user.getPhoneNumber());
            local.setFirstName(user.getFirstName());
            local.setLastName(user.getLastName());
            local.setGender(user.getGender());

            local = this.userRepository.save(local);
        }
        return local;
    }

    //Fetch User by Username
    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    //Fetch user by user Id
    @Override
    public User getUserById(Long userId) {
        Optional<User> local = this.userRepository.findById(userId);

        return local.get();
    }

    //Delete the User
    @Override
    public void deleteUserById(Long userId) {
        this.userRepository.deleteById(userId);
    }
}
