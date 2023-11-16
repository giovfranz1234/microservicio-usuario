package com.helpdesk.microservicio.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class MicroservicioUsuarioApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicioUsuarioApplication.class, args);
    }

}
