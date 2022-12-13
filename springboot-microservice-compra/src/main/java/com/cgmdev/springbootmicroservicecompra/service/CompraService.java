package com.cgmdev.springbootmicroservicecompra.service;

import com.cgmdev.springbootmicroservicecompra.entity.Compra;

import java.util.List;

public interface CompraService {
    Compra saveCompra(Compra compra);

    List<Compra> findAllComprasOfUser(Long id);
}
