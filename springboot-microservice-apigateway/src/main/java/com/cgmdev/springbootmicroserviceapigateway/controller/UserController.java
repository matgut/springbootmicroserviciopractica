package com.cgmdev.springbootmicroserviceapigateway.controller;

import com.cgmdev.springbootmicroserviceapigateway.enumeration.Role;
import com.cgmdev.springbootmicroserviceapigateway.security.UserPrincipal;
import com.cgmdev.springbootmicroserviceapigateway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping("change/{role}")
    //useprincipal es el usuario en sesion
    public ResponseEntity<?> changeRol(@AuthenticationPrincipal UserPrincipal userPrincipal, @PathVariable Role role){
        userService.changeRole(role, userPrincipal.getUsername());
        return ResponseEntity.ok(true);
    }
}
