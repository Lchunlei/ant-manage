package com.ant.app.sql;

import com.ant.app.entity.req.TaskList;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author lchunlei
 * @date 2018/7/6
 */
public class TaskSql {

    public String taskList(TaskList taskList){
        return new SQL() {
            {
                SELECT("*");
                FROM("sys_task");
                if(taskList.getSeleTime()!=null) {
                    WHERE("createTime>#{seleDay}");
                }
                if(taskList.getTaskId()!=null) {
                    WHERE("taskId=${taskId}");
                }
                if(taskList.getTitle()!=null) {
                    WHERE("title LIKE CONCAT('%', #{title},'%')");
                }
            }
        }.toString()+" limit" + " #{startNum},#{pageSize}";
    }

    public String taskListTotal(TaskList taskList){
        return new SQL() {
            {
                SELECT("COUNT(userId)");
                FROM("sys_task");
                if(taskList.getSeleTime()!=null) {
                    WHERE("createTime>#{seleDay}");
                }
                if(taskList.getTaskId()!=null) {
                    WHERE("taskId=${taskId}");
                }
                if(taskList.getTitle()!=null) {
                    WHERE("title LIKE CONCAT('%', #{title},'%')");
                }
            }
        }.toString();
    }
}
