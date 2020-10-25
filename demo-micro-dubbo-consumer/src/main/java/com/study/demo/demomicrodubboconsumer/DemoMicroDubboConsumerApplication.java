package com.study.demo.demomicrodubboconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DemoMicroDubboConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoMicroDubboConsumerApplication.class, args);
    }

}
