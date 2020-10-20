/**************************************************************************
 * Copyright (c) 2006-2020 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：特殊监管区域信息管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package com.study.demo.demohome.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author Baijl
 * 2020/10/20
 * 14:08
 * @description
 */
@Aspect
@Slf4j
@Component
public class AopTest {
    //前置通知
    @Before("execution ( * com.study.demo.demohome.controller.UserInnodbController.* (..))")
    public void auth() {
        log.info("前置通知，假装校验了个权限");
        System.out.println("这是一条前置通知");
    }

    //后置通知
    @Before("execution ( * com.study.demo.demohome.controller.UserInnodbController.* (..))")
    public void after() {
        log.info("后置通知，用于回收某些资源");
        System.out.println("这是一条后置通知");
    }

    //异常通知
    @AfterThrowing("execution ( * com.study.demo.demohome.controller.UserInnodbController.* (..))")
    public void throwSomething() {
        log.info("异常通知，只有异常了才会通知。具体场景，不是特别了解");
    }
}
