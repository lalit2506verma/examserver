package com.exam.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Roles")
public class Role {

    @Id
    private Long roleId;
    private String roleName;
    private String role_Description;

    //Role can be in many userRoles -> One to many
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "role")
    private Set<UserRole> userRoles = new HashSet<>();

    public Role() {
    }

    public Role(Long roleId, String roleName, String role_Description) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.role_Description = role_Description;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRole_Description() {
        return role_Description;
    }

    public void setRole_Description(String role_Description) {
        this.role_Description = role_Description;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}
