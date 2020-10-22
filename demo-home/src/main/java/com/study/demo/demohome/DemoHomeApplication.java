package com.study.demo.demohome;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//两组扫描包路径的第二组可以扫描到common模块下redisutil上的注解
@SpringBootApplication(scanBasePackages = {"com.study.demo.demohome","com.study.demo.democommon"})
@MapperScan("com.study.demo.demohome.mapper")
public class DemoHomeApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoHomeApplication.class, args);
    }

}
