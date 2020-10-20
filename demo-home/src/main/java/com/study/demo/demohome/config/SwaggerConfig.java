/**************************************************************************
 * Copyright (c) 2006-2020 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：特殊监管区域信息管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package com.study.demo.demohome.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author Baijl
 * 2020/10/20
 * 15:01
 * @description
 */
@Configuration
@EnableOpenApi
public class SwaggerConfig {
    //注入swagger3的属性配置文件
    @Autowired
    private  SwaggerProperties swaggerProperties;

    @Bean
    public Docket createRestApi(){
        //创建docket
        return new Docket(DocumentationType.OAS_30)
                //开启swagger
                .enable(swaggerProperties.getEnable())
                //设置api原信息
                .apiInfo(createApiInfo())
                //接口调用地址
                .host(swaggerProperties.getTryHost())
                //查询
                .select()
                //扫描包
                .apis(RequestHandlerSelectors.basePackage("com.study.demo.demohome.controller"))
                //路径
                .paths(PathSelectors.any())
                //生成restapi
                .build();

    }

    /**
     * 设置api的头信息
     * @return
     */
    private ApiInfo createApiInfo() {
        return new ApiInfoBuilder()
                //设置api标题
                .title(swaggerProperties.getApplicationName())
                //项目描述
                .description(swaggerProperties.getApplicationDescription())
                //设置作者信息
                .contact(new Contact("白纪良","无个人博客","bjl_mx@163.com"))
                //项目版本
                .version(swaggerProperties.getApplicationVersion())
                //生成api头信息
                .build();
    }
}
