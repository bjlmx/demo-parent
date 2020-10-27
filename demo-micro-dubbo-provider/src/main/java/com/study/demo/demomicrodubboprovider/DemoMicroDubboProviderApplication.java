package com.study.demo.demomicrodubboprovider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.study.demo.demomicrodubboprovider.mapper")
public class DemoMicroDubboProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoMicroDubboProviderApplication.class, args);
    }

}
