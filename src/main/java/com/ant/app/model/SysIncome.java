package com.ant.app.model;

import java.util.Date;

/**
 * @author lchunlei
 * @date 2018/7/12
 */
public class SysIncome {
    private Integer incomeId;
    private Integer income;//总收入
    private Integer output;//总支出
    private Integer endId;//数据代表截至ID
    private Date updateTime;

    @Override
    public String toString() {
        return "SysIncome{" +
                "incomeId=" + incomeId +
                ", income=" + income +
                ", output=" + output +
                ", endId=" + endId +
                ", updateTime=" + updateTime +
                '}';
    }

    public Integer getIncomeId() {
        return incomeId;
    }

    public void setIncomeId(Integer incomeId) {
        this.incomeId = incomeId;
    }

    public Integer getIncome() {
        return income;
    }

    public void setIncome(Integer income) {
        this.income = income;
    }

    public Integer getOutput() {
        return output;
    }

    public void setOutput(Integer output) {
        this.output = output;
    }

    public Integer getEndId() {
        return endId;
    }

    public void setEndId(Integer endId) {
        this.endId = endId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
