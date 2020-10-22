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
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author Baijl
 * 2020/10/22
 * 13:59
 * @description
 */
@Configuration
public class RedisConfig {
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 修改Redis序列化方式，解决Redis可视化工具乱码问题
     * @return
     */
    @Bean
    public RedisTemplate redisTemplateInit(){
        //设置序列化Key的实例化对象
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //设置序列化Value的实例化对象
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        //设置hash key的序列化对象
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        //设置hash value的序列化对象
        redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer());

        return redisTemplate;
    }
}
