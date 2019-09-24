package com.fairwaysoftware.lms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static final String BASE_PATH = "/api";

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
