package com.ant.app.entity.resp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WebResult<T> implements Serializable {
    private String code = "R000";
    private String message = "操作成功";
    private Integer total;
    private T webData;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getWebData() {
        return webData;
    }

    public void setWebData(T webData) {
        this.webData = webData;
    }
}
