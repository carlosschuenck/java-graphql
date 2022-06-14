package com.graphql.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

import static java.util.Collections.singletonMap;

@SpringBootApplication
public class OrderServiceApplication {

    public static void main(String[] args) {
        /**
         * server.port=${random.int(8081,8085)} - Create a bug, tomcat start with a port and the service register on Eureka with another.
         * server.port=0 - Even though it generates a random port, on Eureka it is registered as my-service:0. This way the service is not able to register more than one instance.
         */
        int port =  new Random().ints(8010, 8015).findFirst().getAsInt();
        SpringApplication app = new SpringApplication(OrderServiceApplication.class);
        app.setDefaultProperties(singletonMap("server.port", port));
        app.run(args);
    }

}
