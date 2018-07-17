package com.ant.app.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lchunlei
 * @date 2018/7/2
 */
public class TimeUtil {
    private static SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //当前时间减去多少天
    public static String deleDay(long i){
        Date d = new Date();
        d = new Date(d.getTime() - i * 24 * 60 * 60 * 1000);
        return format0.format(d);
    }





}
