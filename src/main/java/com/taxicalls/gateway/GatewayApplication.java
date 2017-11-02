package com.taxicalls.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableAutoConfiguration
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class GatewayApplication {

    /**
     * Run the application using Spring Boot and an embedded servlet engine.
     *
     * @param args Program arguments - ignored.
     */
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
