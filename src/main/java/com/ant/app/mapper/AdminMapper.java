package com.ant.app.mapper;

import com.ant.app.model.SysAdmin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author lchunlei
 * @date 2018/9/27
 */
@Repository
public interface AdminMapper {

    @Select("SELECT * FROM sys_admin WHERE passWord=#{passWord} AND adminAlias=#{adminAlias}")
    SysAdmin selectLogin(@Param("passWord")String passWord,@Param("adminAlias")String adminAlias);

}
