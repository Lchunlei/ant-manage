package com.ant.app.util.sdk.impl;

import com.ant.app.util.sdk.IWXPayDomain;
import com.ant.app.util.sdk.WXPayConfig;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class WXPayConfigImpl extends WXPayConfig {

    private byte[] certData;
    private static WXPayConfigImpl INSTANCE;
    private static String appId;
    private static String mchId;
    private static String key;

    private WXPayConfigImpl() throws Exception {
        String certPath = "E://tenpayCert/apiclient_cert.p12";
        File file = new File(certPath);
        InputStream certStream = new FileInputStream(file);
        this.certData = new byte[(int) file.length()];
        certStream.read(this.certData);
        certStream.close();
    }
    private WXPayConfigImpl(String certPath,String appId,String mchId,String key) throws Exception {
        File file = new File(certPath);
        InputStream certStream = new FileInputStream(file);
        this.certData = new byte[(int) file.length()];
        certStream.read(this.certData);
        certStream.close();
    }
    public static WXPayConfigImpl getInstance(String certPath,String appIdd,String mchIdd,String keyy) throws Exception {
        appId=appIdd;
        mchId=mchIdd;
        key=keyy;
        if (INSTANCE == null) {
            synchronized (WXPayConfigImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new WXPayConfigImpl(certPath,appId,mchId,key);
                }
            }
        }
        return INSTANCE;
    }

    public String getAppID() {
        //return "wx4ec36fbefbaeca4b";//生产
        // return "wxdace645e0bc2c424";//测试
        return appId;
    }

    public String getMchID() {
        //return "1485758252";//生产
        //return "1900008951";//测试
        return mchId;
    }

    public String getKey() {

        //return "CHANG2017ZHI08YIN22HANGTENPAYKEY";//生产
        // return "3AC991426F056322E053645AA8C0CC12";//测试
        return key;
    }

    public InputStream getCertStream() {
        ByteArrayInputStream certBis;
        certBis = new ByteArrayInputStream(this.certData);
        return certBis;
    }


    public int getHttpConnectTimeoutMs() {
        return 2000;
    }

    public int getHttpReadTimeoutMs() {
        return 10000;
    }

    public IWXPayDomain getWXPayDomain() {
        return WXPayDomainSimpleImpl.instance();
    }

    public String getPrimaryDomain() {
        return "api.mch.weixin.qq.com";
    }

    public String getAlternateDomain() {
        return "api2.mch.weixin.qq.com";
    }

    @Override
    public int getReportWorkerNum() {
        return 1;
    }

    @Override
    public int getReportBatchSize() {
        return 2;
    }
}
