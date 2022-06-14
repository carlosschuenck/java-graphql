package com.graphql.user;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collections;
import java.util.Random;

import static java.util.Collections.singletonMap;

@SpringBootApplication
public class UserServiceApplication {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static void main(String[] args) {
        /**
         * server.port=${random.int(8081,8085)} - Create a bug, tomcat start with a port and the service register on Eureka with another.
         * server.port=0 - Even though it generates a random port, on Eureka it is registered as my-service:0. This way the service is not able to register more than one instance.
         */
        int port =  new Random().ints(8020, 8025).findFirst().getAsInt();
        SpringApplication app = new SpringApplication(UserServiceApplication.class);
        app.setDefaultProperties(singletonMap("server.port", port));
        app.run(args);
    }

}
