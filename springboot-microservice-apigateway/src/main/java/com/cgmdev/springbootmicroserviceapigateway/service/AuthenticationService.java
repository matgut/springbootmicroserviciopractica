package com.cgmdev.springbootmicroserviceapigateway.service;

import com.cgmdev.springbootmicroserviceapigateway.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {
    User signInAndReturnJwt(User signInRequest);
}
