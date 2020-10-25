package com.study.demo.demodomain.home;

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

    private Integer gender;

    private String phone;

}