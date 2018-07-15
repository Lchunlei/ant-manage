package com.ant.app.entity.req;

/**
 * @author lchunlei
 * @date 2018/7/6
 */
public class TaskList {
    private Integer pageNum;
    private Integer pageSize;
    private Integer seleTime;//过滤时间段
    private Integer startNum;
    private String nameOrId;//按名称和ID查询
    private String taskId;
    private String title;

    @Override
    public String toString() {
        return "TaskList{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", seleTime=" + seleTime +
                ", nameOrId='" + nameOrId + '\'' +
                '}';
    }

    public Integer getStartNum() {
        return startNum;
    }

    public void setStartNum(Integer startNum) {
        this.startNum = startNum;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
