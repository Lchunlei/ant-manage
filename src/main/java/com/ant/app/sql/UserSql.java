package com.ant.app.sql;

import org.apache.ibatis.jdbc.SQL;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lchunlei
 * @date 2018/7/2
 */
public class UserSql{

    @Test
    public void test1(){
        Map<String,Object> param = new HashMap();
        param.put("seleDay",7);
        param.put("userId",12025);
        //param.put("nickName","康熙王朝");
        param.put("startNum",15);
        param.put("pageSize",10);
        System.out.println(userList(param));
        System.out.println(userListTotal(param));

    }

    public String userList(Map<String,Object> param){
        return new SQL() {
            {
                SELECT("*");
                FROM("sys_user");
                if(param.get("seleDay")!=null) {
                    WHERE("createTime>#{seleDay}");
                }
                if(param.get("userId")!=null) {
                    WHERE("userId=#{userId}");
                }
                if(param.get("nickName")!=null) {
                    WHERE("nickName LIKE CONCAT('%', #{nickName},'%')");
                }
            }
        }.toString()+" limit" + " #{startNum},#{pageSize}";
    }

    public String userListTotal(Map<String,Object> param){
        return new SQL() {
            {
                SELECT("COUNT(userId)");
                FROM("sys_user");
                if(param.get("seleDay")!=null) {
                    WHERE("createTime>#{seleDay}");
                }
                if(param.get("userId")!=null) {
                    WHERE("userId=${userId}");
                }
                if(param.get("nickName")!=null) {
                    WHERE("nickName LIKE CONCAT('%', #{nickName},'%')");
                }
            }
        }.toString();
    }



}
