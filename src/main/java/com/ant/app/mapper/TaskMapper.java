package com.ant.app.mapper;

import com.ant.app.entity.req.ReqList;
import com.ant.app.model.SysTask;
import com.ant.app.sql.ReqListSql;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
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

    @Update("UPDATE sys_task SET verifyCode=${verifyCode} WHERE taskId=${taskId}")
    int updateTaskStatus(@Param("verifyCode")Integer verifyCode, @Param("taskId")Integer taskId);

    @Insert("INSERT INTO sys_task(`userId`, `type`,`title`,`jobSeTitle`,`jobUrl`,`maxRead`,`startTime`,`endTime`,`createTime`) VALUES (${userId},${type},#{title},#{jobSeTitle},#{jobUrl},${maxRead},#{startTime},#{endTime},NOW())")
    Integer insertTask(SysTask sysTask);

}
