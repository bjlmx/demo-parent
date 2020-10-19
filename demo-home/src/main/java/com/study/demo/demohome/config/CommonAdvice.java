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
import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.study.demo.democommon.exception.BusinessException;
import com.study.demo.demohome.annotation.CommonReturn;
import com.study.demo.democommon.result.CommonResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
//        System.out.println(returnType.getMethod());
//        System.out.println(returnType.getContainingClass());
//        System.out.println(converterType);
        return AnnotationUtil.hasAnnotation(returnType.getMethod(), CommonReturn.class)||AnnotationUtil.hasAnnotation(returnType.getContainingClass(),CommonReturn.class);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType,
                                  MediaType selectedContentType, Class selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {
        if(body instanceof CommonResult){
            return body;
        }
        if(ObjectUtil.isEmpty(body)){
            return new CommonResult("结果为空");
        }
        if (body instanceof Boolean) {
            if((Boolean) body){
                return new CommonResult();
            }else {
                return new CommonResult("处理失败");
            }
        }
        return new CommonResult(body);

    }

    @ExceptionHandler(value = BusinessException.class)
    public CommonResult<Object> parseException(BusinessException e){
        return new CommonResult<>(ExceptionUtil.getSimpleMessage(e));
    }
}
