/**************************************************************************
 * Copyright (c) 2006-2020 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：特殊监管区域信息管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package com.study.demo.demohome.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Baijl
 * 2020/10/19
 * 10:38
 * @description
 */
public class Demo1 {
    public static void main(String[] args) {
        final ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.execute(()->{
            System.out.println(Thread.currentThread().getName()+"在执行任务");
        });
    }
}
