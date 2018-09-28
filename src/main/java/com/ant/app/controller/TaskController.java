package com.ant.app.controller;

import com.ant.app.entity.req.LayUiAuToReq;
import com.ant.app.entity.req.ReqList;
import com.ant.app.entity.req.TaskList;
import com.ant.app.entity.resp.LayUIItem;
import com.ant.app.entity.resp.LayUiResult;
import com.ant.app.entity.resp.WebResult;
import com.ant.app.model.SysTask;
import com.ant.app.service.TaskServiceImpl;
import com.ant.app.systable.SysTable;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lchunlei
 * @date 2018/7/6
 */
@Api(value = "系统任务",description = "系统任务")
@RestController
@RequestMapping("/ant/task")
public class TaskController {
    private static final Logger log = LoggerFactory.getLogger(TaskController.class);
    @Autowired
    TaskServiceImpl taskService;

    @ApiOperation(value = "任务列表", notes = "任务列表",response=String.class)
    @ApiResponses({@ApiResponse(code = 201, message = "申请成功时返回成功信息")})
    @RequestMapping(value = "/list",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public LayUiResult getlist(LayUiAuToReq layUiAuToReq){
        WebResult<List<SysTask>> result = new WebResult();
        log.info("任务列表请求参数--------》"+layUiAuToReq);
        layUiAuToReq.tableSet(SysTable.SYS_TASK,SysTable.TASK_ID,SysTable.CREAT_TIME,SysTable.TASK_TITAL,SysTable.TASK_ID);
        taskService.getTaskList(layUiAuToReq,result);

        LayUiResult<SysTask> layUiResult = new LayUiResult();
        layUiResult.setCode(0);
        layUiResult.setMsg("成功");
        layUiResult.setCount(result.getTotal());
        layUiResult.setData(result.getWebData());
        log.info("--------》"+result);
        return layUiResult;
    }

    @ApiOperation(value = "任务状态修改", notes = "任务状态修改",response=String.class)
    @ApiResponses({@ApiResponse(code = 201, message = "申请成功时返回成功信息")})
    @RequestMapping(value = "/update",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public WebResult updaTask(Integer taskId,Integer verifyCode){
        WebResult<List<SysTask>> result = new WebResult();
        log.info("任务状态修改请求参数--------》"+taskId+"***"+verifyCode);
        taskService.updaTaskStatus(taskId,verifyCode,result);
        log.info("--------》"+result);
        return result;
    }

    @ApiOperation(value = "增加任务", notes = "增加任务",response=String.class)
    @ApiResponses({@ApiResponse(code = 201, message = "申请成功时返回成功信息")})
    @RequestMapping(value = "/add",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public WebResult addTask(@RequestBody SysTask sysTask){
        WebResult result = new WebResult();
        log.info("增加任务请求参数--------》"+sysTask);
        taskService.addTask(sysTask,result);
        log.info("--------》"+result);
        return result;
    }





}
