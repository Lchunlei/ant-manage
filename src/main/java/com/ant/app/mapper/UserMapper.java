package com.ant.app.mapper;

import com.ant.app.entity.req.ReqList;
import com.ant.app.model.UserInfo;
import com.ant.app.sql.ReqListSql;
import com.ant.app.sql.UserSql;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

/**
 * Created by liuchunlei on 2018/6/13 0027.
 */
@Repository
public interface UserMapper {

//    @Select("SELECT * FROM sys_user limit ${startNum},${pageSize}")
//    List<UserInfo> selectBypage(@Param("startNum") Integer startNum, @Param("pageSize") Integer pageSize);
//    @Select("SELECT COUNT(userId) FROM sys_user")
//    int selecttotallNum();

    @SelectProvider(type=ReqListSql.class, method="reqList")
    List<UserInfo> selectBypage(ReqList reqList);
    @SelectProvider(type=ReqListSql.class, method="reqListTotal")
    int selecttotallNum(ReqList reqList);

    @Update("UPDATE sys_user SET status=${status} WHERE userId=${userId}")
    int updateUserStatus(@Param("status")Integer status,@Param("userId")Integer userId);



}
