package com.cgmdev.springbootmicroserviceapigateway.service;

import com.cgmdev.springbootmicroserviceapigateway.entity.User;

public interface AutenticationService {
    User signInAndReturnJwt(User signInRequest);
}
