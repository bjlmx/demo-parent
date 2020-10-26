/**************************************************************************
 * Copyright (c) 2006-2020 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：特殊监管区域信息管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package com.study.demo.demomicrodubboconsumer.controller;

import com.study.demo.democommonapi.microservice.DubboService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Baijl
 * 2020/10/25
 * 20:23
 * @description
 */
@RestController
@Slf4j
@RefreshScope
@RequestMapping("dubbo")
public class DubboController {
    @Reference
    private DubboService dubboService;

    @Value("${user.name}")
    private String userName;

    @GetMapping("/get")
    public String get() {
        log.info("获取配置信息："+userName);
        return userName;
    }

    @GetMapping("test")
    public String dubboTest(){
        log.info("消费者dubbo成功");
        return dubboService.test();
    }
}
