/**************************************************************************
 * Copyright (c) 2006-2020 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：特殊监管区域信息管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package com.study.demo.demohome.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Baijl
 * 2020/10/20
 * 11:06
 * @description
 */
public class ProxyInterceptor implements InvocationHandler {
    //被代理类
    private Object obj;
    //AOP切面类
    private AopAspect aop;

    public ProxyInterceptor(Object obj, AopAspect aop) {
        this.obj = obj;
        this.aop = aop;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //method是被代理类中要执行的方法
        if("insert".equals(method.getName())||"update".equals(method.getName())) {
            this.aop.begin();
            //执行被代理类的方法 Obj是被代理的对象
            method.invoke(obj);
            this.aop.end();
        }else {
            method.invoke(obj);
        }
        return null;
    }


    public static void main(String[] args) {
        //创建被代理类和切面类对象
        ProxyServiceImpl proxyService = new ProxyServiceImpl();
        AopAspect aopAspect = new AopAspect();
        //创建代理类
        ProxyInterceptor proxyInterceptor = new ProxyInterceptor(proxyService, aopAspect);

        //通过代理类得出被代理类
        ProxyService o = (ProxyService) Proxy.newProxyInstance(proxyService.getClass().getClassLoader(),
                proxyService.getClass().getInterfaces(), proxyInterceptor);

        o.insert();

    }
}
