package com.canalplus.abonnement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AbonnementApplication {

    public static void main(String[] args) {
        SpringApplication.run(AbonnementApplication.class, args);
    }
}