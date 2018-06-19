package com.ant.app.entity.resp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AppResult implements Serializable {
    private String code = "R000";
    private String message = "操作成功";
    private List data;

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

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
    public void setOneData(Object oneData) {
        List da = new ArrayList();
        da.add(oneData);
        this.data = da;
    }
}
