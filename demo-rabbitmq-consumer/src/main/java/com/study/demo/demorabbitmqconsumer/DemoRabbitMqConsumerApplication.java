package com.study.demo.demorabbitmqconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//@EnableAsync
@EnableDiscoveryClient
@SpringBootApplication
public class DemoRabbitMqConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoRabbitMqConsumerApplication.class, args);
    }

}
