package com.ant.app.entity.req;

/**
 * @author lchunlei
 * @date 2018/9/26
 */
public class LayuiPageReq {
    private Integer pageNum;
    private Integer pageSize;
    private String searchValue;
    private String sDate;
    private String eDate;

    /**
     *  数据库字段如下
     **/
    private String tableName;
    private String tableKey;
    //筛选的时间段
    private String seleTime;
    //筛选名称
    private String seleName;
    //排序字段
    private String tableSort;
    //分页开始数
    private Integer startNum;

    @Override
    public String toString() {
        return "LayuiPageReq{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", searchValue='" + searchValue + '\'' +
                ", sDate='" + sDate + '\'' +
                ", eDate='" + eDate + '\'' +
                ", tableName='" + tableName + '\'' +
                ", tableKey='" + tableKey + '\'' +
                ", seleTime='" + seleTime + '\'' +
                ", seleName='" + seleName + '\'' +
                ", tableSort='" + tableSort + '\'' +
                ", startNum=" + startNum +
                '}';
    }

    public void tableSet(String tablName, String tablKey, String selTime, String selName, String tablSort){
        this.tableName=tablName;
        this.tableKey=tablKey;
        this.seleTime=selTime;
        this.seleName=selName;
        this.tableSort=tablSort;
    }

    public Integer getStartNum() {
        return startNum;
    }

    public void setStartNum(Integer startNum) {
        this.startNum = startNum;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableKey() {
        return tableKey;
    }

    public void setTableKey(String tableKey) {
        this.tableKey = tableKey;
    }

    public String getSeleTime() {
        return seleTime;
    }

    public void setSeleTime(String seleTime) {
        this.seleTime = seleTime;
    }

    public String getSeleName() {
        return seleName;
    }

    public void setSeleName(String seleName) {
        this.seleName = seleName;
    }

    public String getTableSort() {
        return tableSort;
    }

    public void setTableSort(String tableSort) {
        this.tableSort = tableSort;
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

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public String getsDate() {
        return sDate;
    }

    public void setsDate(String sDate) {
        this.sDate = sDate;
    }

    public String geteDate() {
        return eDate;
    }

    public void seteDate(String eDate) {
        this.eDate = eDate;
    }
}
