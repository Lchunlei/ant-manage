package com.ant.app.service;

import com.ant.app.Constants;
import com.ant.app.entity.req.LayuiPageReq;
import com.ant.app.entity.req.ReqList;
import com.ant.app.entity.req.UserList;
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

    public void getUserList(LayuiPageReq reqList, WebResult<List<UserInfo>> result){
        reqList.setStartNum((reqList.getPageNum()-1)*10);
        List<UserInfo> userInfos = userMapper.selectByPage(reqList);
        if(userInfos.size()==0){
            result.setCode(Constants.ERROR_CODE);
            result.setMessage(Constants.NOT_MORE_INFO);
        }else{
            result.setWebData(userInfos);
            result.setTotal(userMapper.selectTotallNum(reqList));
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
