package com.ant.app.mapper;

import com.ant.app.model.AppMsg;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

/**
 * @author lchunlei
 * @date 2018/7/11
 */
@Repository
public interface AppMsgMapper {

    @Insert("INSERT INTO push_msg(`title`, `content`,`pushtime`,`msgType`,`userId`) VALUES (#{title}, #{content},NOW(),${msgType},${userId})")
    Integer insertAppMsg(AppMsg appMsg);





}
