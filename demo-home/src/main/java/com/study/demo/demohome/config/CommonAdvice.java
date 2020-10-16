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

import cn.hutool.core.annotation.AnnotationUtil;
import cn.hutool.core.util.ObjectUtil;
import com.study.demo.demohome.annotation.CommonReturn;
import com.study.demo.demohome.common.CommonResult;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author Baijl
 * 2020/10/16
 * 17:14
 * @description
 */
@RestControllerAdvice
public class CommonAdvice implements ResponseBodyAdvice {
    public boolean supports(MethodParameter returnType, Class converterType) {
//        System.out.println(returnType.getMethod());
//        System.out.println(returnType.getContainingClass());
//        System.out.println(converterType);
        return AnnotationUtil.hasAnnotation(returnType.getMethod(), CommonReturn.class)||AnnotationUtil.hasAnnotation(returnType.getContainingClass(),CommonReturn.class);
    }

    public Object beforeBodyWrite(Object body, MethodParameter returnType,
                                  MediaType selectedContentType, Class selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {
        if(body instanceof CommonReturn){
            return body;
        }
        if(ObjectUtil.isEmpty(body)){
            return new CommonResult("结果为空");
        }
        return new CommonResult(body);

    }
}
