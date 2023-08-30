package com.example.TaskManager.Service.Impl;

import com.example.TaskManager.Entity.Role;
import com.example.TaskManager.Entity.Users;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class SecUserDetails implements UserDetails {

    String email;
    @JsonIgnore
    String password;
    List<Role> roles;

    SecUserDetails(Users user){
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.roles = user.getRoles();
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
         return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getTitle()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
