package com.cgmdev.springbootmicroserviceinmueble.controller;

import com.cgmdev.springbootmicroserviceinmueble.entity.Inmueble;
import com.cgmdev.springbootmicroserviceinmueble.service.InmuebleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/inmueble")
public class InmuebleController {

    @Autowired
    private InmuebleService inmuebleService;


    @PostMapping
    public ResponseEntity<?> saveInmueble(@RequestBody Inmueble inmueble){
        Inmueble newInmueble = inmuebleService.saveInmueble(inmueble);
        return new ResponseEntity<>(newInmueble, HttpStatus.CREATED);
    }

    @DeleteMapping("{inmuebleId}")
    public ResponseEntity<?> deleteInmueble(@PathVariable Long inmuebleId){
        inmuebleService.deleteInmueble(inmuebleId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllInmuebles(){
        return ResponseEntity.ok(inmuebleService.findAllInmuebles());
    }




}
