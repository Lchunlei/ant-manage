package com.ant.app.service;

import com.ant.app.Constants;
import com.ant.app.entity.req.TaskList;
import com.ant.app.entity.resp.WebResult;
import com.ant.app.mapper.TaskMapper;
import com.ant.app.model.SysTask;
import com.ant.app.util.CheckReqUtil;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @author lchunlei
 * @date 2018/7/6
 */
@Service
public class TaskServiceImpl {
    @Autowired
    TaskMapper taskMapper;

    public void getTaskList(TaskList taskList, WebResult<List<SysTask>> result){
        if(taskList.getPageNum()==null||taskList.getPageNum()==0){
            taskList.setPageNum(1);
            taskList.setPageSize(10);
        }
        if(!StringUtils.isNullOrEmpty(taskList.getNameOrId())){
            if(CheckReqUtil.isNumber(taskList.getNameOrId())){
                taskList.setTaskId(taskList.getNameOrId());
            }else{
                taskList.setTitle(taskList.getNameOrId());
            }
        }
        List<SysTask> tasks = taskMapper.selectBypage(taskList);
        if(tasks.size()==0){
            result.setCode(Constants.ERROR_CODE);
            result.setMessage(Constants.NOT_MORE_INFO);
        }else {
            result.setWebData(tasks);
            result.setTotal(taskMapper.selecttotallNum(taskList));
        }
    }

    //禁用任务
    public void updaTaskStatus(Integer taskId,Integer verifyCode,WebResult result){
        if(taskMapper.updateTaskStatus(verifyCode,taskId)<1){
            result.setCode(Constants.ERROR_CODE);
            result.setMessage(Constants.FILE_MSG);
        }
    }

    public void addTask(SysTask sysTask,WebResult result){
        //计算出最大有赏阅读次数
        int i = sysTask.getJobAmount()/2;
        sysTask.setMaxRead(i);
        sysTask.setType(0);
        int j = taskMapper.insertTask(sysTask);
        if(j<1){
            result.setCode(Constants.ERROR_CODE);
            result.setMessage(Constants.FILE_MSG);
        }
    }

}
