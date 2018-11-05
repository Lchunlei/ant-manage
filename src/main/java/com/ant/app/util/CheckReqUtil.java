package com.ant.app.util;

import java.util.regex.Pattern;

/**
 * Created by sfb_liuchunlei on 2018/6/23.
 */
public class CheckReqUtil {

    public static Boolean isNumber(String str){
        if(StringTool.isRealStr(str)){
            Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
            return pattern.matcher(str).matches();
        }else {
            return false;
        }
    }

}
