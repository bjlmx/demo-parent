package com.study.demo.demohome.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (UserInnodb)实体类
 *
 * @author Baijl
 * @since 2020-10-16 17:03:13
 */
@Data
public class UserInnodb implements Serializable {
    private static final long serialVersionUID = -62260988976878562L;
    
    private Integer id;
    
    private String name;
    
    private Object gender;
    
    private String phone;


}