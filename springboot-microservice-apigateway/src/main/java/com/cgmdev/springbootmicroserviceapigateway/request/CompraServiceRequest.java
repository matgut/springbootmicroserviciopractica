package com.cgmdev.springbootmicroserviceapigateway.request;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

//mapeo para comunicar el microservicio
@FeignClient(
        value = "compra-microservice",
        path = "/api/v1/compra",
        //url = "${compra.service.url}",
        configuration = FeignConfiguration.class
)
public interface CompraServiceRequest {

    @PostMapping
    Object saveCompra(@RequestBody Object compra);


    @GetMapping("{userId}")
    List<Object> findAllComprasOfUser(@PathVariable("userId") Long userId);

}
