package com.example.TaskManager.Service.Impl;

import com.example.TaskManager.Entity.User;
import com.example.TaskManager.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Transactional
@Service("userDetailsService")
public class SecUserDetailsService implements UserDetailsService {


    private final UserRepository userRepo;

    SecUserDetailsService(UserRepository userRepo){
        this.userRepo = userRepo;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepo.findUsersByEmail(email);
        UserDetails userDetails = new SecUserDetails(user);

        return userDetails;
    }
}
