package com.ant.app.mapper;

import com.ant.app.model.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by liuchunlei on 2018/6/13 0027.
 */
@Repository
public interface UserMapper {

    @Select("SELECT * FROM sys_user limit ${startNum},${pageSize}")
    List<UserInfo> selectBypage(@Param("startNum") Integer startNum, @Param("pageSize") Integer pageSize);
    @Select("SELECT COUNT(userId) FROM sys_user")
    int selecttotallNum();

    @Update("UPDATE sys_user SET status=${status} WHERE userId=${userId}")
    int updateUserStatus(@Param("status")Integer status,@Param("userId")Integer userId);

}
