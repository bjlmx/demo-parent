package com.study.demo.demohome.controller;

import cn.hutool.http.HttpUtil;
import com.study.demo.demohome.annotation.CommonReturn;
import com.study.demo.demohome.entity.UserInnodb;
import com.study.demo.demohome.service.UserInnodbService;
import lombok.extern.slf4j.Slf4j;
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
/*自定义注解：统一封装返回值*/
@CommonReturn
@RequestMapping("userInnodb")
@Slf4j
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
        log.info("处理成功");
        return this.userInnodbService.getById(id);
    }

    @GetMapping("list")
    public List<UserInnodb> list(){
        log.info("处理OK");
        return this.userInnodbService.list();
    }

    @PutMapping("update")
    public boolean updateUserInnodb(UserInnodb userInnodb) {
        log.info("处理成功");
        return this.userInnodbService.saveOrUpdate(userInnodb);
    }

    @DeleteMapping("delete/{id}")
    public boolean deleteUserInnodb(@PathVariable("id")Integer id) {
        log.info("处理成功");
        return this.userInnodbService.removeById(id);
    }

    @GetMapping("exception")
    public boolean exceptionTest() {
        log.info("处理成功");
        return this.userInnodbService.exceptionTest(1);
    }

}