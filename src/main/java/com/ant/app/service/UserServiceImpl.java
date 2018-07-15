package com.ant.app.service;

import com.ant.app.Constants;
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

    public void getUserList(UserList userListReq, WebResult<List<UserInfo>> result){

        int startNum = (userListReq.getPageNum()-1)*userListReq.getPageSize();
        Map<String,Object> param = new HashMap();
        param.put("startNum",startNum);
        param.put("pageSize",userListReq.getPageSize());
        if(userListReq.getSeleTime()!=null){
            Date seleDay = TimeUtil.deleDay(userListReq.getSeleTime());
            param.put("seleDay",seleDay);
        }
        if(userListReq.getNameOrId()==null){

        }else if(CheckReqUtil.isNumber(userListReq.getNameOrId())){
            param.put("userId",userListReq.getNameOrId());
        }else {
            param.put("nickName",userListReq.getNameOrId());
        }
        List<UserInfo> userInfos = userMapper.selectBypage(param);
        if(userInfos.size()==0){
            result.setCode(Constants.ERROR_CODE);
            result.setMessage(Constants.NOT_MORE_INFO);
        }else{
            result.setWebData(userInfos);
            result.setTotal(userMapper.selecttotallNum(param));
        }

    }

    public void updaUserStatus(Integer status,Integer userID,WebResult result){
        int i = userMapper.updateUserStatus(status,userID);
        if(i!=1){
            result.setCode(Constants.ERROR_CODE);
            result.setMessage(Constants.FILE_MSG);
        }

    }



}
