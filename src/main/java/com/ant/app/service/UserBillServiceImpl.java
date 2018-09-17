package com.ant.app.service;

import com.ant.app.Constants;
import com.ant.app.entity.req.ReqList;
import com.ant.app.entity.resp.WebResult;
import com.ant.app.mapper.UserBillMapper;
import com.ant.app.model.UserBill;
import com.ant.app.util.CheckReqUtil;
import com.ant.app.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author lchunlei
 * @date 2018/7/11
 */
@Service
public class UserBillServiceImpl {

    @Autowired
    UserBillMapper userBillMapper;

    //查看用户积分，充值，体现记录
    public void getBillList(ReqList reqList, WebResult<List<UserBill>> result){
        reqList.setTable("user_bill","billid","userId",null,"billid");
        List<UserBill> userBills = userBillMapper.selectBypage(reqList);
        if(userBills.size()==0){
            result.setCode(Constants.ERROR_CODE);
            result.setMessage(Constants.NOT_MORE_INFO);
        }else {
            result.setTotal(userBillMapper.selecttotallNum(reqList));
            result.setWebData(userBills);
        }
    }

    //查看平台  前一天，前一个月，总收入




}
