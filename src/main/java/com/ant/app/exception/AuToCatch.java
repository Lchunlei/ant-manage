package com.ant.app.exception;

import com.ant.app.entity.resp.WebResult;
import com.ant.app.Constants;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sfb_liuchunlei on 2017/3/24 0024.
 */
@Component
public class AuToCatch implements HandlerExceptionResolver {
    private static final Logger log = LoggerFactory.getLogger(AuToCatch.class);
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mv=new ModelAndView();
        Gson gson=new Gson();
        WebResult respApp=new WebResult();
        /*  使用response返回 */
        response.setStatus(HttpStatus.OK.value()); //设置状态码200
        response.setContentType(MediaType.APPLICATION_JSON_VALUE); //设置ContentType
        response.setCharacterEncoding("UTF-8"); //避免乱码
        response.setHeader("Cache-Control", "no-cache, must-revalidate");
        respApp.setCode("R444");
        log.error(ex.getMessage(),ex);
        if(ex instanceof ConnException){
            respApp.setMessage(Constants.CONNECT_ERROR);
        }else if(ex instanceof DbException){
            respApp.setMessage(Constants.DB_ERROR);
        }else if(ex instanceof DNException){
            respApp.setMessage("身份信息有误，录入失败");
        }else{
            respApp.setMessage("系统繁忙，请稍后！"+ex.getMessage());
        }
        try {
            response.getWriter().write(gson.toJson(respApp));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mv;
    }
}
