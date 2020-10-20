package com.study.demo.demohome.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * (UserInnodb)实体类
 *
 * @author Baijl
 * @since 2020-10-16 17:03:13
 */
@Data
@ApiModel(value = "用户类")
public class UserInnodb implements Serializable {
    private static final long serialVersionUID = -62260988976878562L;


    @ApiModelProperty(value = "id")
    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField
    @ApiModelProperty(value = "用户名称")
    @NotEmpty(message = "用户名称不为空")
    private String name;

    @TableField
    @ApiModelProperty(value = "用户性别")
    @NotNull(message="用户性别")
    private Integer gender;

    @TableField
    @ApiModelProperty(value="联系电话")
    @NotEmpty(message = "电话不能为空")
    private String phone;

}