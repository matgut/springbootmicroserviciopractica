package com.cgmdev.springbootmicroserviceapigateway.controller;

import com.cgmdev.springbootmicroserviceapigateway.request.CompraServiceRequest;
import com.cgmdev.springbootmicroserviceapigateway.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("gateway/compra")
public class CompraController {

    @Autowired
    private CompraServiceRequest compraServiceRequest;

    @PostMapping
    public ResponseEntity<?> saveCompra(@RequestBody Object compra){
        return new ResponseEntity<>(compraServiceRequest.saveCompra(compra), HttpStatus.CREATED);
    }

    //user principal se mapea del token que se ingresa
    @GetMapping("{userId}")
    public ResponseEntity<?> getAllComprasOfUser(@AuthenticationPrincipal UserPrincipal userPrincipal){
        return ResponseEntity.ok(compraServiceRequest.findAllComprasOfUser(userPrincipal.getId()));
    }
}
