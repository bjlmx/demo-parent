/**************************************************************************
 * Copyright (c) 2006-2020 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：特殊监管区域信息管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package com.study.demo.demorabbitmqprovider.config;

import com.study.demo.democommon.rabbitmq.RoutingKey;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Baijl
 * 2020/10/21
 * 13:44
 * @description 创建队列和直连交换机
 */
@Configuration
public class RabbitMqConfig {
    @Value("${spring.rabbitmq.queueName}")
    private  String queueName;
    @Value("${spring.rabbitmq.exchangeName}")
    private  String exchangeName;
    @Autowired
    private ConnectionFactory connectionFactory;
    /**
     * 创建队列持久化
     * @return
     */
    @Bean
    public Queue createQueue(){
        return new Queue(queueName,true);
    }

    /**
     * 创建直连交换机
     * @return
     */
    @Bean
    public DirectExchange createDirectExchange() {
        //交换机名称 是否持久化 是否自动删除
        return new DirectExchange(exchangeName,true,false);
    }

    /**
     * 将队列使用routingKey绑定交换机
     * @return
     */
    @Bean
    public Binding createKey(){
        return BindingBuilder.bind(createQueue()).to(createDirectExchange()).with(RoutingKey.DEMO_KEY);
    }

    /**
     * 创建生产端回调函数配置
     * @param
     * @return
     */
    @Bean
    public RabbitTemplate createRabbitMQTemplate(){
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        //创建连接工厂
        rabbitTemplate.setConnectionFactory(connectionFactory);
        //任何情况下都开启回调函数
        rabbitTemplate.setMandatory(true);
        //创建交换机回调函数
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean b, String s) {
                System.out.println("ConfirmCallback:     "+"相关数据："+correlationData);
                System.out.println("ConfirmCallback:     "+"确认情况："+b);
                System.out.println("ConfirmCallback:     "+"原因："+s);
            }
        });

        //创建队列回调函数
        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText,
                                        String exchange, String routingKey) {
                System.out.println("ReturnCallback:     "+"消息："+message);
                System.out.println("ReturnCallback:     "+"回应码："+replyCode);
                System.out.println("ReturnCallback:     "+"回应信息："+replyText);
                System.out.println("ReturnCallback:     "+"交换机："+exchange);
                System.out.println("ReturnCallback:     "+"路由键："+routingKey);
            }
        });

        return rabbitTemplate;
    }
}
