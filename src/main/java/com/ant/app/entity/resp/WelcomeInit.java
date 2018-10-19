package com.ant.app.entity.resp;

/**
 * @author lchunlei
 * @date 2018/10/19
 */
public class WelcomeInit {
    //新增热文
    private Integer newTaskNum;
    //新增用户
    private Integer newUserNum;
    //昨日收入
    private String yestIncome;
    //总收入
    private String totalIncome;
    //时间
    private String uTime;

    @Override
    public String toString() {
        return "WelcomeInit{" +
                "newTaskNum=" + newTaskNum +
                ", newUserNum=" + newUserNum +
                ", yestIncome='" + yestIncome + '\'' +
                ", totalIncome='" + totalIncome + '\'' +
                ", uTime='" + uTime + '\'' +
                '}';
    }

    public String getuTime() {
        return uTime;
    }

    public void setuTime(String uTime) {
        this.uTime = uTime;
    }

    public Integer getNewTaskNum() {
        return newTaskNum;
    }

    public void setNewTaskNum(Integer newTaskNum) {
        this.newTaskNum = newTaskNum;
    }

    public Integer getNewUserNum() {
        return newUserNum;
    }

    public void setNewUserNum(Integer newUserNum) {
        this.newUserNum = newUserNum;
    }

    public String getYestIncome() {
        return yestIncome;
    }

    public void setYestIncome(String yestIncome) {
        this.yestIncome = yestIncome;
    }

    public String getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(String totalIncome) {
        this.totalIncome = totalIncome;
    }
}
