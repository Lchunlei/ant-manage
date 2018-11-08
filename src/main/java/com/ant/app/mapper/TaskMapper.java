package com.ant.app.mapper;

import com.ant.app.entity.req.LayUiAuToReq;
import com.ant.app.entity.req.ReqList;
import com.ant.app.model.SysTask;
import com.ant.app.sql.LayuiAutoPageSql;
import com.ant.app.sql.ReqListSql;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @author lchunlei
 * @date 2018/7/6
 */
@Repository
public interface TaskMapper {

    @SelectProvider(type=ReqListSql.class, method="reqList")
    List<SysTask> selectBypage(ReqList reqList);
    @SelectProvider(type=ReqListSql.class, method="reqListTotal")
    int selecttotallNum(ReqList reqList);


    @SelectProvider(type=LayuiAutoPageSql.class, method="reqList")
    List<SysTask> selectByPage(LayUiAuToReq layUiAuToReq);
    @SelectProvider(type=LayuiAutoPageSql.class, method="reqListTotal")
    Integer selectTotallNum(LayUiAuToReq layUiAuToReq);

    @Update("UPDATE sys_task SET verifyCode=${verifyCode},verifyMsg=#{verifyMsg,jdbcType=VARCHAR} WHERE taskId=${taskId}")
    int updateTaskStatus(@Param("verifyCode")Integer verifyCode, @Param("taskId")Integer taskId,@Param("verifyMsg")String verifyMsg);

    @Insert("INSERT INTO sys_task(`userId`, `type`,`title`,`jobSeTitle`,`jobUrl`,`maxRead`,`startTime`,`endTime`,`createTime`) VALUES (${userId},${type},#{title},#{jobSeTitle},#{jobUrl},${maxRead},#{startTime},#{endTime},NOW())")
    Integer insertTask(SysTask sysTask);

    @Select("SELECT COUNT(*) FROM sys_task WHERE createTime>#{sTime} AND createTime<#{eTime}")
    Integer findNewTaskNum(@Param("sTime")String sTime, @Param("eTime")String eTime);

}
