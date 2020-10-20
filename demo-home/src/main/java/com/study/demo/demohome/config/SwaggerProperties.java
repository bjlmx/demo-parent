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

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Baijl
 * 2020/10/20
 * 15:05
 * @description
 */
@Component
@Data
@ConfigurationProperties(prefix = "swagger3",ignoreUnknownFields = false)
public class SwaggerProperties {
    /**
     * 是否开启swagger3.0
     */
    private Boolean enable;
    /**
     * 项目标题
     */
    private String applicationName;
    /**
     * 项目版本号
     */
    private String applicationVersion;
    /**
     * 项目描述
     */
    private String applicationDescription;
    /**
     * 项目调试地址
     */
    private String tryHost;

}
