package com.cgmdev.springbootmicroserviceapigateway.entity;

import com.cgmdev.springbootmicroserviceapigateway.enumeration.Role;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "user")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", unique = true, nullable = false, length = 100)
    private String username;

    @Column(name = "password", unique = true, nullable = false)
    private String password;

    @Column(name = "nombre", unique = true, nullable = false)
    private String nombre;

    @Column(name = "fecha_creacion", unique = true, nullable = false)
    private LocalDateTime fechaCreacion;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    @Transient//sera un campo temporal y no se almacenara en la DB
    private String token;


}
