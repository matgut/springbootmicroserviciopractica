package com.cgmdev.springbootmicroserviceapigateway.request;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//mapeo para comunicar el microservicio
@FeignClient(value = "inmueble-microservice", path = "/api/inmueble", url = "${nmueble.service.url}", configuration = FeignConfiguration.class)
public interface InmuebleServiceRequest {

    @PostMapping
    Object saveInmueble(@RequestBody Object requestBody);

    @DeleteMapping("{inmuebleId}")
    void deleteInmueble(@PathVariable Long requestBody);

    @GetMapping
    List<Object> getAllInmueble();
}
