package com.cgmdev.springbootmicroservicecompra.service;

import com.cgmdev.springbootmicroservicecompra.entity.Compra;
import com.cgmdev.springbootmicroservicecompra.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CompraServiceImp implements CompraService{

    @Autowired
    private CompraRepository compraRepository;

    @Override
    public Compra saveCompra(Compra compra){
        compra.setFechaCompra(LocalDateTime.now());
        return compraRepository.save(compra);
    }

    @Override
    public List<Compra> findAllComprasOfUser(Long id){
        return compraRepository.findAllByUserId(id);

    }


}
