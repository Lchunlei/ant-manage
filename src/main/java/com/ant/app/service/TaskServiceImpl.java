package com.ant.app.service;

import com.ant.app.Constants;
import com.ant.app.entity.req.LayUiAuToReq;
import com.ant.app.entity.req.LayuiPageReq;
import com.ant.app.entity.req.ReqList;
import com.ant.app.entity.req.TaskList;
import com.ant.app.entity.resp.WebResult;
import com.ant.app.mapper.TaskMapper;
import com.ant.app.model.SysTask;
import com.ant.app.util.CheckReqUtil;
import com.ant.app.util.TimeUtil;
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

    public void getTaskList(LayUiAuToReq reqList, WebResult<List<SysTask>> result){
        reqList.setStartNum((reqList.getPage()-1)*10);
        List<SysTask> userBanks = taskMapper.selectByPage(reqList);
        if(userBanks.size()==0){
            result.setCode(Constants.ERROR_CODE);
            result.setMessage(Constants.NOT_MORE_INFO);
        }else{
            result.setWebData(userBanks);
            result.setTotal(taskMapper.selectTotallNum(reqList));
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
        sysTask.setType(0);
        int j = taskMapper.insertTask(sysTask);
        if(j<1){
            result.setCode(Constants.ERROR_CODE);
            result.setMessage(Constants.FILE_MSG);
        }
    }

}
