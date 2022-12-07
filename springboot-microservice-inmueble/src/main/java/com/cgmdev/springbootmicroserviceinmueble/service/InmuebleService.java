package com.cgmdev.springbootmicroserviceinmueble.service;

import com.cgmdev.springbootmicroserviceinmueble.entity.Inmueble;

import java.util.List;

public interface InmuebleService {

    Inmueble saveInmueble(Inmueble inmueble);
    void deleteInmueble(Long inmuebleId);
    List<Inmueble> findAllInmuebles();
}
