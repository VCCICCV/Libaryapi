package com.example.libary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class LibaryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibaryApplication.class, args);
    }

    @GetMapping
    public String health() {
        return "success";
    }
}
