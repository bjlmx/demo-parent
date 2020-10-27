/**************************************************************************
 * Copyright (c) 2006-2020 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：特殊监管区域信息管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package com.study.demo.demomicrodubboconsumer.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Baijl
 * 2020/10/26
 * 17:10
 * @description
 */
@Data
public class UserCsvDto {

    private Integer id;
    @NotEmpty(message = "姓名不能为空")
    private String name;
    @NotNull(message = "性别不能为空")
    private Integer gender;
    @NotEmpty(message = "手机号不能为空")
    private String phone;
}
