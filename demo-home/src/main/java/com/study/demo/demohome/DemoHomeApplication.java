package com.study.demo.demohome;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@MapperScan("com.study.demo.demohome.mapper")
public class DemoHomeApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoHomeApplication.class, args);
    }

}
