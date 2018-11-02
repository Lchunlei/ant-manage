package com.ant.app.service;

import com.ant.app.Constants;
import com.ant.app.entity.req.LayUiAuToReq;
import com.ant.app.entity.resp.WebResult;
import com.ant.app.mapper.DrawOrderMapper;
import com.ant.app.mapper.UserBankMapper;
import com.ant.app.mapper.UserMapper;
import com.ant.app.model.DrawOrder;
import com.ant.app.model.UserInfo;
import com.ant.app.util.StringTool;
import com.ant.app.util.sdk.WXPay;
import com.ant.app.util.sdk.WXPayUtil;
import com.ant.app.util.sdk.impl.WXPayClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lchunlei
 * @date 2018/9/17
 */
@Service
public class DrawOrderServiceImpl {
    private static final Logger log = LoggerFactory.getLogger(DrawOrderServiceImpl.class);

    @Value("${weixin.pay.certPath}")
    private String certPathWX;
    @Value("${weixin.pay.appid}")
    private String appIdWX;
    @Value("${weixin.pay.mchId}")
    private String mchIdWX;
    @Value("${weixin.pay.key}")
    private String keyWX;
    @Value("${this.web.ip}")
    private String mywebIp;

    @Autowired
    DrawOrderMapper drawOrderMapper;
    @Autowired
    UserBankMapper userBankMapper;
    @Autowired
    UserMapper userMapper;

    public void getAllList(LayUiAuToReq layUiAuToReq, WebResult<List<DrawOrder>> result){
        layUiAuToReq.setStartNum((layUiAuToReq.getPage()-1)*10);
        Integer totallNumAll = drawOrderMapper.selectTotallNum(layUiAuToReq);
        if(totallNumAll>0){
            result.setWebData(drawOrderMapper.selectByPage(layUiAuToReq));
            result.setTotal(totallNumAll);
        }else{
            result.setCode(Constants.ERROR_CODE);
            result.setMessage(Constants.NOT_MORE_INFO);
        }
    }
    @Transactional
    public void updaDrawMapper(DrawOrder drawOrder, WebResult result){
        if(!drawOrder.getDrawStatus().equals(0)){
            DrawOrder order = drawOrderMapper.selectById(drawOrder.getDrawId());
            if(order==null){
                result.setCode(Constants.ERROR_CODE);
                result.setMessage(Constants.DATA_NULL);
            }else {
                if(order.getDrawStatus().equals(0)){
                    order.setBankStatus(1);//初始化已冲正
                    order.setDrawStatus(1);//初始化提现成功
                    order.setPaymentTime(new Date());//初始化提现时间
                    if(StringTool.isRealStr(drawOrder.getTradeDes())){
                        order.setTradeDes(drawOrder.getTradeDes());
                    }
                    if(drawOrder.getDrawStatus().equals(1)){
                        //返现审核通过
                        //立即提现
                        try {
                            HashMap<String, String> data = new HashMap();
                            data.put(Constants.WX_TO_APPID,appIdWX);
                            data.put(Constants.WX_TO_MCHID,mchIdWX);
                            data.put(Constants.WX_TO_TRADE_NO, order.getTradeNoTo());
                            data.put(Constants.WX_NONCE_STR, WXPayUtil.generateUUID());
                            data.put(Constants.WX_TO_CHECK_NAME, Constants.WX_TO_CHECK_NAME_VALUE);
                            data.put(Constants.WX_TO_OPEN_ID,order.getOpenId());
                            data.put(Constants.WX_TO_DESC,Constants.MONEY_TO_ANT_DES);
                            data.put(Constants.WX_TO_AMOUNT,order.getAmount().toString());
                            data.put(Constants.WX_CREATE_IP,mywebIp);

                            WXPay wxPay = WXPayClient.getWxPay(certPathWX,appIdWX,mchIdWX,keyWX);
                            Map<String, String> r = wxPay.sendMoneyTo(data);

                            if(Constants.PAY_SUCCESS_CODE.equals(r.get(Constants.PAY_RESULT_CODE))){
                                //提现立即响应成功，扣除提现余额
                                String payTime1 = r.get(Constants.WX_PAYMENT_TIME);
                                String payTime2 = payTime1.replace("：",":");
                                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                Date payTime =formatter.parse(payTime2);
                                order.setPaymentTime(payTime);
                            }else{
                                order.setDrawStatus(2);
                                if(StringTool.isRealStr(r.get(Constants.PAY_CODE_DES))){
                                    order.setTradeDes(r.get(Constants.PAY_CODE_DES));
                                }else {
                                    order.setTradeDes(r.get(Constants.PAY_RETURN_MSG));
                                }
                                result.setCode(Constants.ERROR_CODE);
                                result.setMessage(order.getTradeDes());
                            }
                        }catch (Exception e){
                            log.error(e.getMessage(),e);
                            order.setDrawStatus(2);
                            result.setCode(Constants.ERROR_CODE);
                            result.setMessage(Constants.CONNECT_ERROR);
                        }
                    }
                    int re = drawOrderMapper.updateDrawOrderStatus(order);
                    if(re!=1){
                        result.setCode(Constants.ERROR_CODE);
                        result.setMessage(Constants.FILE_MSG);
                    }else {
                        //提现申请失败，账户余额增加
                        if(order.getDrawStatus().equals(2)){
                            userBankMapper.addNowMoney(order.getAmount(),order.getBankId());
                        }
                    }
                }else {
                    result.setCode(Constants.ERROR_CODE);
                    result.setMessage(Constants.FILE_MSG);
                }
            }
        }

    }

    public void seleById(Integer drawId, WebResult<DrawOrder> result){
        DrawOrder order = drawOrderMapper.selectById(drawId);
        if(order==null){
            result.setCode(Constants.ERROR_CODE);
            result.setMessage(Constants.DATA_NULL);
        }else if(order.getDrawStatus().equals(0)){
            result.setCode(Constants.ERROR_CODE);
            result.setMessage(Constants.CHECK_FIRST);
        }else if(order.getDrawStatus().equals(1)){
            result.setMessage(Constants.DRAW_SUCCESS);
        }else {
            //查询返现结果
            try {
                HashMap<String, String> data = new HashMap();
                data.put(Constants.WX_TO_APPID,appIdWX);
                data.put(Constants.WX_TO_MCHID,mchIdWX);
                data.put(Constants.WX_TO_TRADE_NO, order.getTradeNoTo());
                data.put(Constants.WX_NONCE_STR, WXPayUtil.generateUUID());

                WXPay wxPay = WXPayClient.getWxPay(certPathWX,appIdWX,mchIdWX,keyWX);
                Map<String, String> r = wxPay.findMoneyTo(data);
                if(Constants.PAY_SUCCESS_CODE.equals(r.get(Constants.GET_MONEY_STATUS))){
                    //提现成功
                    if(!(order.getBankStatus().equals(1)&&order.getDrawStatus().equals(1))){
                        //刷新数据库
                        order.setDrawStatus(1);
                        order.setBankStatus(1);
                        order.setTradeDes(Constants.DRAW_SUCCESS);
                        String payTime1 = r.get(Constants.WX_PAYMENT_TIME);
                        String payTime2 = payTime1.replace("：",":");
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        Date payTime =formatter.parse(payTime2);
                        order.setPaymentTime(payTime);
                        drawOrderMapper.updateDrawOrderStatus(order);
                    }
                    result.setMessage(Constants.DRAW_SUCCESS);
                }else{
                    if(StringTool.isRealStr(r.get(Constants.WX_REASON))){
                        order.setTradeDes(r.get(Constants.WX_REASON));
                    }else if(StringTool.isRealStr(r.get(Constants.PAY_CODE_DES))){
                        order.setTradeDes(r.get(Constants.PAY_CODE_DES));
                    }else {
                        order.setTradeDes(r.get(Constants.PAY_RETURN_MSG));
                    }
                    result.setCode(Constants.ERROR_CODE);
                    result.setMessage(order.getTradeDes());
                }
            }catch (Exception e){
                log.error(e.getMessage(),e);
                result.setCode(Constants.ERROR_CODE);
                result.setMessage(Constants.CONNECT_ERROR);
            }
        }
    }


}
