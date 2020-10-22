/**************************************************************************
 * Copyright (c) 2006-2020 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：特殊监管区域信息管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package com.study.demo.democommon.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author Baijl
 * 2020/10/15
 * 15:34
 * @description
 */
@Component
public class RedisUtil {
    @Autowired
    private  RedisTemplate redisTemplate;

    /**
     * 返回符合给定模式的 key 列表
     * @param key
     * @return
     */
    public List<String> keys(String key){
        Set keys = redisTemplate.keys(key + "*");
        return new ArrayList<String>(keys);
    }

    /**
     * 根据key列表批量获取value
     * @param keyList
     * @return
     */
    public List multiGet(List keyList){
        return redisTemplate.opsForValue().multiGet(keyList);
    }

    /***
     * 添加string类型数据
     */
    public void setString(String key,Object value){
        redisTemplate.opsForValue().set(key, value);
    }

    /***
     * 添加string类型数据（超时设置）
     */
    public void setStringTime(String key,Object value,Integer time){
        redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
    }

    /***
     * 获取string类型数据
     * @return
     */
    public Object getString(String key){
       return redisTemplate.opsForValue().get(key);
    }

    /***
     * 删除数据
     * @return
     */
    public void delete(String key){
         redisTemplate.delete(key);
    }
    /***
     * 清空数据
     * @return
     */
    public void deleteAll(Collection<String> keys){
        redisTemplate.delete(keys);
    }

    /***
     * 分布式锁实现
     * @return
     */
    public void lock(){
//        redisTemplate.
    }
}
