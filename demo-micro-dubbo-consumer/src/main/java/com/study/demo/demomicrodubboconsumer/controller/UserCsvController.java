/**************************************************************************
 * Copyright (c) 2006-2020 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：特殊监管区域信息管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package com.study.demo.demomicrodubboconsumer.controller;

import com.study.demo.democommon.annotation.CommonReturn;
import com.study.demo.democommonapi.microservice.UserCsvService;
import com.study.demo.demodomain.consumer.UserCsv;
import com.study.demo.demomicrodubboconsumer.dto.UserCsvDto;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

/**
 * @author Baijl
 * 2020/10/26
 * 17:07
 * @description
 */
@RestController
@RequestMapping("userCsv")
@CommonReturn
public class UserCsvController {
    @Reference
    private UserCsvService userCsvService;

    @PostMapping("add")
    public Object addUserCsv(@RequestBody @Validated UserCsvDto userCsvDto, BindingResult result){
        if(result.hasFieldErrors()){
          return result.getFieldErrors().stream().map(x->"异常属性："+x.getField()+",异常原因："+x.getDefaultMessage()).collect(Collectors.toList());
        }
        UserCsv userCsv = new UserCsv();
        BeanUtils.copyProperties(userCsvDto, userCsv);
        return userCsvService.saveEntity(userCsv);
    }
}
