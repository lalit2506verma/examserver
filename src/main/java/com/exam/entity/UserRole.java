package com.exam.entity;

import javax.persistence.*;

@Entity
@Table(name = "User_Role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userRole_ID;

    //user
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    //Role
    @ManyToOne
    private Role role;

    public UserRole(){
    }

    public Long getUserRole_ID() {
        return userRole_ID;
    }

    public void setUserRole_ID(Long userRole_ID) {
        this.userRole_ID = userRole_ID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
