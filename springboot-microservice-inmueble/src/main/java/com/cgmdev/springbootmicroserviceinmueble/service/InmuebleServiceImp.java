package com.cgmdev.springbootmicroserviceinmueble.service;

import com.cgmdev.springbootmicroserviceinmueble.entity.Inmueble;
import com.cgmdev.springbootmicroserviceinmueble.repository.InmuebleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InmuebleServiceImp implements InmuebleService{

    @Autowired
    private InmuebleRepository inmuebleRepository;

    @Override
    public Inmueble saveInmueble(Inmueble inmueble){
        inmueble.setFechaCreacion(LocalDateTime.now());
        return inmuebleRepository.save(inmueble);
    }

    @Override
    public void deleteInmueble(Long inmuebleId){
        inmuebleRepository.deleteById(inmuebleId);
    }

    @Override
    public List<Inmueble> findAllInmuebles(){
        return inmuebleRepository.findAll();
    }
}
