/**************************************************************************
 * Copyright (c) 2006-2020 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：特殊监管区域信息管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package com.study.demo.demohome.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.study.demo.democommon.page.PageSo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Baijl
 * 2020/10/24
 * 19:50
 * @description
 */
@Data
public class UserDto extends PageSo {
    @TableField
    @ApiModelProperty(value = "用户名称")
//    @NotEmpty(message = "用户名称不为空")
    private String name;

    @TableField
    @ApiModelProperty(value = "用户性别")
//    @NotNull(message="用户性别")
    private Integer gender;

    @TableField
    @ApiModelProperty(value="联系电话")
//    @NotEmpty(message = "电话不能为空")
    private String phone;
}
