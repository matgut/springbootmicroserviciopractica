package com.cgmdev.springbootmicroserviceapigateway.service;

import com.cgmdev.springbootmicroserviceapigateway.entity.User;
import com.cgmdev.springbootmicroserviceapigateway.enumeration.Role;
import com.cgmdev.springbootmicroserviceapigateway.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user){

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setFechaCreacion(LocalDateTime.now());

        return userRepository.save(user);
    }

    
    @Override
    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Transactional
    @Override
    public void changeRole(Role newRole, String username){
        userRepository.updateUserRole(username, newRole);
    }


}
