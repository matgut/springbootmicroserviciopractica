package com.cgmdev.springbootmicroservicecompra.repository;

import com.cgmdev.springbootmicroservicecompra.entity.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompraRepository extends JpaRepository<Compra, Long> {
    List<Compra> findAllByUserId(Long id);
}
