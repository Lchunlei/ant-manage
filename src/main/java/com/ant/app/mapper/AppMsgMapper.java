package com.ant.app.mapper;

import com.ant.app.entity.req.LayUiAuToReq;
import com.ant.app.model.AppMsg;
import com.ant.app.sql.LayuiAutoPageSql;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lchunlei
 * @date 2018/7/11
 */
@Repository
public interface AppMsgMapper {

    @Insert("INSERT INTO push_msg(`title`, `content`,`pushtime`,`msgType`,`userId`,`nickName`,`createTime`) VALUES (#{title}, #{content}, #{pushtime},${msgType},#{userId,jdbcType=VARCHAR},#{nickName,jdbcType=VARCHAR},NOW())")
    Integer insertAppMsg(AppMsg appMsg);

    @SelectProvider(type=LayuiAutoPageSql.class, method="reqList")
    List<AppMsg> selectByPage(LayUiAuToReq layUiAuToReq);
    @SelectProvider(type=LayuiAutoPageSql.class, method="reqListTotal")
    Integer selectTotallNum(LayUiAuToReq layUiAuToReq);

    @Delete("DELETE FROM push_msg WHERE msgId IN (${msgids})")
    Integer deleteMsgs(@Param("msgids")String msgids);

}
