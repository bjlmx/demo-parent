package com.study.demo.demohome.controller;

import com.study.demo.demohome.annotation.CommonReturn;
import com.study.demo.demohome.entity.UserInnodb;
import com.study.demo.demohome.service.UserInnodbService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (UserInnodb)表控制层
 *
 * @author Baijl
 * @since 2020-10-16 17:03:16
 */
@RestController
@CommonReturn
@RequestMapping("userInnodb")
public class UserInnodbController {
    /**
     * 服务对象
     */
    @Resource
    private UserInnodbService userInnodbService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @PostMapping("selectOne/{id}")
    public UserInnodb selectOne(@PathVariable("id") Integer id) {
        UserInnodb byId = this.userInnodbService.getById(id);
        return byId;
    }

    @GetMapping("list")
    public List<UserInnodb> list(){
//        userService.exceptionTest();
        List<UserInnodb> list = userInnodbService.list();
        return list;
    }

}