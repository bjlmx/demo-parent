package com.study.demo.demohome.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.mapper.Mapper;
import com.study.demo.demohome.entity.UserInnodb;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (UserInnodb)表数据库访问层
 *
 * @author Baijl
 * @since 2020-10-16 17:03:15
 */
public interface UserInnodbMapper extends BaseMapper<UserInnodb> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserInnodb queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UserInnodb> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param userInnodb 实例对象
     * @return 对象列表
     */
    List<UserInnodb> queryAll(UserInnodb userInnodb);

    /**
     * 新增数据
     *
     * @param userInnodb 实例对象
     * @return 影响行数
     */
    int insert(UserInnodb userInnodb);

    /**
     * 修改数据
     *
     * @param userInnodb 实例对象
     * @return 影响行数
     */
    int update(UserInnodb userInnodb);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}