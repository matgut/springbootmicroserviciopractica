package com.cgmdev.springbootmicroserviceinmueble.repository;

import com.cgmdev.springbootmicroserviceinmueble.entity.Inmueble;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InmuebleRepository extends JpaRepository<Inmueble, Long> {


}
