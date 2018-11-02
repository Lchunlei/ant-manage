package com.ant.app.service;

import com.ant.app.Constants;
import com.ant.app.entity.req.LayUiAuToReq;
import com.ant.app.entity.req.LayuiPageReq;
import com.ant.app.entity.req.ReqList;
import com.ant.app.entity.req.UserList;
import com.ant.app.entity.resp.LayUiResult;
import com.ant.app.entity.resp.WebResult;
import com.ant.app.mapper.UserMapper;
import com.ant.app.model.UserInfo;
import com.ant.app.util.CheckReqUtil;
import com.ant.app.util.TimeUtil;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sfb_liuchunlei on 2018/6/23.
 */
@Service
public class UserServiceImpl {
    @Autowired
    UserMapper userMapper;

    public void getUserList(ReqList reqList, WebResult<List<UserInfo>> result){

        List<UserInfo> userInfos = userMapper.selectBypage(reqList);
        if(userInfos.size()==0){
            result.setCode(Constants.ERROR_CODE);
            result.setMessage(Constants.NOT_MORE_INFO);
        }else{
            result.setWebData(userInfos);
            result.setTotal(userMapper.selecttotallNum(reqList));
        }

    }

    public void getUserList(LayUiAuToReq layUiAuToReq, LayUiResult<UserInfo> result){
        layUiAuToReq.setStartNum((layUiAuToReq.getPage()-1)*10);
        Integer totallNumAll = userMapper.selectTotallNum(layUiAuToReq);
        if(totallNumAll>0){
            result.setCode(0);
            result.setMsg("成功");
            result.setCount(totallNumAll);
            result.setData(userMapper.selectByPage(layUiAuToReq));
        }else{
            result.setCode(Constants.PAGE_ERROR_CODE);
            result.setMsg(Constants.NOT_MORE_INFO);
        }

    }

    public void updaUserStatus(Integer userID,WebResult result){
        UserInfo userInfo = userMapper.selectByiD(userID);
        if(userInfo==null){
            result.setCode(Constants.ERROR_CODE);
            result.setMessage(Constants.DATA_NULL);
        }else {
            int status=0;
            if(userInfo.getStatus().equals(0)){
                status=1;
            }
            int i = userMapper.updateUserStatus(status,userID);
            if(i!=1){
                result.setCode(Constants.ERROR_CODE);
                result.setMessage(Constants.FILE_MSG);
            }
        }
    }



}
