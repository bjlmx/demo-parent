package com.study.demo.demorabbitmqprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DemoRabbitMqProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoRabbitMqProviderApplication.class, args);
    }

}
