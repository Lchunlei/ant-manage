package com.ant.app.util;

import java.util.Date;

/**
 * @author lchunlei
 * @date 2018/7/2
 */
public class TimeUtil {

    //当前时间减去多少天
    public static Date deleDay(int i){
        Date d = new Date();
        d = new Date(d.getTime() - i * 24 * 60 * 60 * 1000);
        return d;
    }





}
