/**************************************************************************
 * Copyright (c) 2006-2020 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：特殊监管区域信息管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package com.study.demo.demohome.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.study.demo.demodomain.home.UserInnodb;
import com.study.demo.demohome.dto.UserDto;

/**
 * @author Baijl
 * 2020/10/16
 * 17:06
 * @description
 */
public interface UserInnodbService extends IService<UserInnodb> {

    boolean exceptionTest(int i);

    /**
     * 条件查询
     * @return
     * @param userDto
     */
    Object conditionList(UserDto userDto);
}
