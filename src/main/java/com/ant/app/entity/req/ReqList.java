package com.ant.app.entity.req;

import com.ant.app.Constants;
import com.ant.app.util.CheckReqUtil;
import com.ant.app.util.TimeUtil;

import java.util.Date;

/**
 * @author lchunlei
 * @date 2018/7/11
 */
public class ReqList {
    private Integer pageNum;
    private Integer pageSize;
    private Integer seleTime;//过滤时间段
    private String nameOrId;//按名称和ID查询

    private String tableName;//表名
    private String tableKey;//表的主键
    private String columnId;//id对应列名
    private String columnName;//name对应列名


    private Date stime;
    private Integer reqId;
    private String reqName;

    @Override
    public String toString() {
        return "ReqList{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", seleTime=" + seleTime +
                ", nameOrId='" + nameOrId + '\'' +
                '}';
    }

    public void setTable(String tname,String tkey,String cid,String cname){
        if(this.pageSize==null||this.pageSize==0){
            this.setPageNum(1);
            this.setPageSize(10);
        }
        if(this.seleTime!=null){
            this.setStime(TimeUtil.deleDay(this.seleTime));
        }
        if(this.nameOrId!=null){
            if(CheckReqUtil.isNumber(this.nameOrId)){
                this.setReqId(Integer.parseInt(this.nameOrId));
            }else{
                this.setReqName(this.nameOrId);
            }
        }
        this.setTableName(tname);
        this.setTableKey(tkey);
        this.setColumnName(cname);
        this.setColumnId(cid);
    }
    public String getTableKey() {
        return tableKey;
    }

    public void setTableKey(String tableKey) {
        this.tableKey = tableKey;
    }

    public String getColumnId() {
        return columnId;
    }

    public void setColumnId(String columnId) {
        this.columnId = columnId;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Date getStime() {
        return stime;
    }

    public void setStime(Date stime) {
        this.stime = stime;
    }

    public Integer getReqId() {
        return reqId;
    }

    public void setReqId(Integer reqId) {
        this.reqId = reqId;
    }

    public String getReqName() {
        return reqName;
    }

    public void setReqName(String reqName) {
        this.reqName = reqName;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getSeleTime() {
        return seleTime;
    }

    public void setSeleTime(Integer seleTime) {
        this.seleTime = seleTime;
    }

    public String getNameOrId() {
        return nameOrId;
    }

    public void setNameOrId(String nameOrId) {
        this.nameOrId = nameOrId;
    }
}
