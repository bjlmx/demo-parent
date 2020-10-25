/**************************************************************************
 * Copyright (c) 2006-2020 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：特殊监管区域信息管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package com.study.demo.demohome.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.demo.democommon.exception.BusinessException;
import com.study.demo.democommon.page.PageVo;
import com.study.demo.demohome.dto.UserDto;
import com.study.demo.demohome.entity.UserInnodb;
import com.study.demo.demohome.mapper.UserInnodbMapper;
import com.study.demo.demohome.service.UserInnodbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Baijl
 * 2020/10/16
 * 17:07
 * @description
 */
@Service
public class UserInnodbServiceImpl extends ServiceImpl<UserInnodbMapper, UserInnodb> implements UserInnodbService  {
@Autowired
private UserInnodbMapper userInnodbMapper;
    @Override
    public boolean exceptionTest(int i) {
        if(1==i){
            throw BusinessException.get("抛出异常测试");
        }
        return false;
    }

    @Override
    public Object conditionList(UserDto userDto) {
        Page<UserInnodb> page = new Page<>(userDto.getPageIndex(), userDto.getPageSize());
        QueryWrapper<UserInnodb> userInnodbQueryWrapper = new QueryWrapper<>();
        userInnodbQueryWrapper.eq(ObjectUtil.isNotEmpty(userDto.getGender()),"gender",userDto.getGender())
                .eq(ObjectUtil.isNotEmpty(userDto.getName()),"name",userDto.getName())
                .eq(ObjectUtil.isNotEmpty(userDto.getPhone()),"phone",userDto.getPhone());
        Page<UserInnodb> userInnodbPage = userInnodbMapper.selectPage(page, userInnodbQueryWrapper);
        return new PageVo<>(userInnodbPage.getTotal(),userInnodbPage.getRecords());
    }
}
