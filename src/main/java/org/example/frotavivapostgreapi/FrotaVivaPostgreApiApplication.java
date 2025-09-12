package org.example.frotavivapostgreapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class FrotaVivaPostgreApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FrotaVivaPostgreApiApplication.class, args);
    }

}
