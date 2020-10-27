package com.study.demo.demodomain.consumer;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * (UserCsv)实体类
 *
 * @author makejava
 * @since 2020-10-26 16:59:38
 */
@Data
public class UserCsv implements Serializable {
    private static final long serialVersionUID = 859676571929083233L;
    @TableId
    private Integer id;
    @TableField
    private String name;
    @TableField
    private Integer gender;
    @TableField
    private String phone;


}