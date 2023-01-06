package com.cgmdev.springbootmicroserviceeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
//eureka server sirve para registrar los microservicios, y no es necesario de introducir
// la url en la apigateway, ya que se ira por el nombre del servicio
@EnableEurekaServer
@SpringBootApplication
public class SpringbootMicroserviceEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMicroserviceEurekaApplication.class, args);
	}

}
