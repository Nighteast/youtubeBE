package com.example.pj2be;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class Pj2BeApplication {

    public static void main(String[] args) {
        SpringApplication.run(Pj2BeApplication.class, args);
    }

}
