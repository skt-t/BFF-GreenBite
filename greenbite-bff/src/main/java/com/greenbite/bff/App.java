package com.greenbite.bff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        // Esto levanta el servidor Tomcat en el puerto 8080 (por defecto)
        SpringApplication.run(App.class, args);
    }
}