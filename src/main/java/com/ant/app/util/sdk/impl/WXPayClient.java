package com.ant.app.util.sdk.impl;


import com.ant.app.util.sdk.WXPay;

public class WXPayClient {

    private static WXPay wxPay = null;
    private WXPayClient(){}
    public static synchronized WXPay getWxPay(String certPath,String appIdd,String mchIdd,String keyy) throws Exception {
        if(null == wxPay){
            wxPay = new WXPay(WXPayConfigImpl.getInstance(certPath,appIdd,mchIdd,keyy));
        }
        return wxPay;
    }

}
