package com.ant.app.entity.req;

import com.ant.app.Constants;
import com.ant.app.util.CheckReqUtil;
import com.ant.app.util.TimeUtil;
import org.springframework.util.StringUtils;

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
    private String columnSort;//排序字段

    private String stime;
    private Integer reqId;
    private String reqName;
    private Integer startNum;
    @Override
    public String toString() {
        return "ReqList{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", seleTime=" + seleTime +
                ", nameOrId='" + nameOrId + '\'' +
                ", tableName='" + tableName + '\'' +
                ", tableKey='" + tableKey + '\'' +
                ", columnId='" + columnId + '\'' +
                ", columnName='" + columnName + '\'' +
                ", stime=" + stime +
                ", reqId=" + reqId +
                ", reqName='" + reqName + '\'' +
                '}';
    }
    //表名，主键，过滤其他ID列名，过滤字符串列名，排序字段
    public void setTable(String tname, String tkey, String cid, String cname,String csort){
        if(this.pageNum==null||this.pageNum==0){
            this.setPageNum(1);
        }
        this.setPageSize(10);
        if(this.seleTime!=null&&this.seleTime>2){
            this.setStime(TimeUtil.deleDay(this.seleTime));
        }
        if(!StringUtils.isEmpty(this.nameOrId)){
            if(CheckReqUtil.isNumber(this.nameOrId)){
                this.setReqId(Integer.parseInt(this.nameOrId));
            }else{
                this.setReqName(this.nameOrId);
            }
        }
        this.setStartNum((this.getPageNum()-1)*this.getPageSize());
        this.setTableName(tname);
        this.setTableKey(tkey);
        this.setColumnName(cname);
        this.setColumnId(cid);
        this.setColumnSort(csort);
    }

    public String getColumnSort() {
        return columnSort;
    }

    public void setColumnSort(String columnSort) {
        this.columnSort = columnSort;
    }

    public Integer getStartNum() {
        return startNum;
    }

    public void setStartNum(Integer startNum) {
        this.startNum = startNum;
    }

    public String getStime() {
        return stime;
    }

    public void setStime(String stime) {
        this.stime = stime;
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
