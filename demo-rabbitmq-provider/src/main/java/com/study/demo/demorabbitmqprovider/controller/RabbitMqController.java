/**************************************************************************
 * Copyright (c) 2006-2020 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：特殊监管区域信息管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package com.study.demo.demorabbitmqprovider.controller;

import com.study.demo.democommon.rabbitmq.RoutingKey;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Baijl
 * 2020/10/21
 * 14:07
 * @description
 */
@RestController
@Slf4j
@Api(tags="消息队列模块")
public class RabbitMqController {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Value("${spring.rabbitmq.exchangeName}")
    private  String exchangeName;

    @GetMapping(value = "test")
    public void testMessage(){
        rabbitTemplate.convertAndSend(exchangeName, RoutingKey.DEMO_KEY,"测试消息");
    }
}
