package com.megshan.immiportalservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc // This is needed along with the @Configuration annotation on the {@link MvcConfig} class for interceptors to work
@SpringBootApplication
public class ImmiportalserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImmiportalserviceApplication.class, args);
    }

}
