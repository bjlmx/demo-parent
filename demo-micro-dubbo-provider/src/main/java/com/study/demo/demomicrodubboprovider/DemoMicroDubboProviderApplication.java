package com.study.demo.demomicrodubboprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DemoMicroDubboProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoMicroDubboProviderApplication.class, args);
    }

}
