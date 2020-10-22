/**************************************************************************
 * Copyright (c) 2006-2020 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：特殊监管区域信息管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package com.study.demo.demohome.controller;

import com.study.demo.democommon.util.RedisUtil;
import com.study.demo.democommon.annotation.CommonReturn;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Baijl
 * 2020/10/22
 * 15:22
 * @description
 */
@CommonReturn
@Api(tags = "redis模块")
@Slf4j
@RequestMapping("redis")
@RestController
public class RedisController {
    @Autowired
    private RedisUtil redisUtil;



    @GetMapping("setRedis")
    @ApiOperation("设置redis测试")
    public void setRedisTest() {
        log.info("处理成功");
        redisUtil.setString("test1","测试1");
    }

    @GetMapping("setRedisTime")
    @ApiOperation("设置redis超时测试")
    public void setRedisTimeTest() {
        log.info("处理成功");
        redisUtil.setStringTime("test1","测试1",20);
    }

    @GetMapping("getRedis")
    @ApiOperation("获取redisvalue测试")
    public void getRedisTest() {
        log.info("处理成功");
        String value = (String) redisUtil.getString("test1");
        log.info("Redis值："+value);
    }

    @GetMapping("deleteRedis")
    @ApiOperation("删除redisvalue测试")
    public void deleteRedisTest() {
        log.info("处理成功");
        redisUtil.delete("test1");
    }

}
