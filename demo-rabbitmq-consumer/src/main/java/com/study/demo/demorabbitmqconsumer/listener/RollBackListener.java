/**************************************************************************
 * Copyright (c) 2006-2020 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：特殊监管区域信息管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package com.study.demo.demorabbitmqconsumer.listener;

import cn.hutool.core.exceptions.ExceptionUtil;
import com.rabbitmq.client.Channel;
import com.study.demo.demorabbitmqconsumer.service.RabbitMqService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Baijl
 * 2020/10/21
 * 16:49
 * @description 手动监听类
 */
@Component
@Slf4j
public class RollBackListener implements ChannelAwareMessageListener {
    @Autowired
    private RabbitMqService rabbitMqService;

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            String toString = message.toString();
            System.out.println(toString);
            String[] split = toString.split("'");
            System.out.println(split[1]);
            rabbitMqService.async(split[1]);
            channel.basicAck(deliveryTag, true);
        }catch (Exception e) {
            /*
            手动消息确认机制：
            当监听到消息后进行处理，但是出现异常后需要手动将信息重新放回队列
            这表示服务端没有进行处理并且也需要重新接收消息
             */
            log.error(ExceptionUtil.getSimpleMessage(e));
            channel.basicReject(deliveryTag,true);
        }
    }
}
