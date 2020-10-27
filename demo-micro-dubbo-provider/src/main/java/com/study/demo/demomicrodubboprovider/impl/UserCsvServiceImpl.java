/**************************************************************************
 * Copyright (c) 2006-2020 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：特殊监管区域信息管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package com.study.demo.demomicrodubboprovider.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.demo.democommon.exception.BusinessException;
import com.study.demo.democommonapi.microservice.UserCsvService;
import com.study.demo.demodomain.consumer.UserCsv;
import com.study.demo.demomicrodubboprovider.mapper.UserCsvMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Baijl
 * 2020/10/26
 * 17:03
 * @description
 */
@Service
@Slf4j
//多应用单一数据源可以使用本地事务
@Transactional
public class UserCsvServiceImpl extends ServiceImpl<UserCsvMapper, UserCsv> implements UserCsvService {
    @Autowired
    private UserCsvMapper userCsvMapper;
    @Override
    public boolean saveEntity(UserCsv userCsv) {
        if(StrUtil.equals(userCsv.getName(),"consumer")){

            log.error("有属性为空，抛出异常");
            throw BusinessException.get("有属性为空，抛出异常");
        }
        return userCsvMapper.insert(userCsv) >0;
    }
}
