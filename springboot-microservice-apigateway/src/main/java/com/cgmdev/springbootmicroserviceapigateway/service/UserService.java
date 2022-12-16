package com.cgmdev.springbootmicroserviceapigateway.service;

import com.cgmdev.springbootmicroserviceapigateway.entity.User;
import com.cgmdev.springbootmicroserviceapigateway.enumeration.Role;

import java.util.Optional;

public interface UserService {
    User saveUser(User user);

    Optional<User> findByUsername(String username);

    void changeRole(Role newRole, String username);
}
