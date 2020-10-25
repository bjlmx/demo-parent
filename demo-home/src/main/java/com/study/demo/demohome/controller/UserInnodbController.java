package com.study.demo.demohome.controller;

import com.study.demo.democommon.annotation.AopFlag;
import com.study.demo.democommon.annotation.CommonReturn;
import com.study.demo.democommon.util.RedisUtil;
import com.study.demo.demodomain.home.UserInnodb;
import com.study.demo.demohome.dto.UserDto;
import com.study.demo.demohome.service.UserInnodbService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

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
@Api(tags = "用户模块")
public class UserInnodbController {
    /**
     * 服务对象
     */
    @Resource
    private UserInnodbService userInnodbService;
    /**
     * Redis工具类
     */
    @Autowired
    private RedisUtil redisUtil;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation("查询用户")
    @PostMapping("selectOne/{id}")
    public UserInnodb selectOne(@PathVariable("id") Integer id) {
        log.info("处理成功");
        return this.userInnodbService.getById(id);
    }

    @GetMapping("list")
    @AopFlag
    @ApiOperation("查询用户")
    public List<UserInnodb> list(){
        log.info("处理OK");
        return this.userInnodbService.list();
    }

    @PostMapping("conditionList")
    @AopFlag
    @ApiOperation("查询用户")
    public Object conditionList(@RequestBody@Validated UserDto userDto, BindingResult result){
        log.info("热部署处理OK");
        if(result.hasErrors()){
            return result.getFieldErrors().stream().map(x->"异常属性："+x.getField()+"，异常原因"+x.getDefaultMessage()).collect(Collectors.toList());
        }
        return this.userInnodbService.conditionList(userDto);
    }

    @PostMapping("updateOrAdd")
    @ApiOperation("更新或新增用户")
    public Object updateUserInnodb(@RequestBody @Validated UserInnodb userInnodb, BindingResult result) {
        log.info("处理成功");
        if(result.hasErrors()){
            return result.getFieldErrors().stream().map(x->"异常字段名："+x.getField()+"，异常原因："+x.getDefaultMessage()).collect(Collectors.toList());
        }
        return this.userInnodbService.saveOrUpdate(userInnodb);
    }

    @DeleteMapping("delete/{id}")
    @ApiOperation("删除用户")
    public boolean deleteUserInnodb(@PathVariable("id")Integer id) {
        log.info("处理成功");
        return this.userInnodbService.removeById(id);
    }

    @GetMapping("exception")
    @ApiOperation("异常测试")
    public boolean exceptionTest() {
        log.info("处理成功");
        return this.userInnodbService.exceptionTest(1);
    }


}