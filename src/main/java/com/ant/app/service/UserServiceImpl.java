package com.ant.app.service;

import com.ant.app.Constants;
import com.ant.app.entity.req.UserList;
import com.ant.app.entity.resp.WebResult;
import com.ant.app.mapper.UserMapper;
import com.ant.app.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sfb_liuchunlei on 2018/6/23.
 */
@Service
public class UserServiceImpl {
    @Autowired
    UserMapper userMapper;

    public void getUserList(UserList userListReq, WebResult<List<UserInfo>> result){
        int startNum = (userListReq.getPageNum()-1)*userListReq.getPageSize();
        List<UserInfo> userInfos = userMapper.selectBypage(startNum,userListReq.getPageSize());
        if(userInfos.size()==0){
            result.setCode(Constants.ERROR_CODE);
            result.setMessage(Constants.NOT_MORE_INFO);
        }else{
            result.setWebData(userInfos);
            result.setTotal(userMapper.selecttotallNum());
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
