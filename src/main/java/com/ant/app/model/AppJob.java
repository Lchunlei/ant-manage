package com.ant.app.model;

public class AppJob {
    private String jobTitle;
    private String jobSeTitle;
    private String jobType;
    private String jobAmount;
    private String jobUrl;

    public AppJob() {
    }

    public AppJob(String jobTitle, String jobSeTitle, String jobType, String jobAmount, String jobUrl) {
        this.jobTitle = jobTitle;
        this.jobSeTitle = jobSeTitle;
        this.jobType = jobType;
        this.jobAmount = jobAmount;
        this.jobUrl = jobUrl;
    }

    @Override
    public String toString() {
        return "AppJob{" +
                "jobTitle='" + jobTitle + '\'' +
                ", jobSeTitle='" + jobSeTitle + '\'' +
                ", jobType='" + jobType + '\'' +
                ", jobAmount='" + jobAmount + '\'' +
                ", jobUrl='" + jobUrl + '\'' +
                '}';
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobSeTitle() {
        return jobSeTitle;
    }

    public void setJobSeTitle(String jobSeTitle) {
        this.jobSeTitle = jobSeTitle;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getJobAmount() {
        return jobAmount;
    }

    public void setJobAmount(String jobAmount) {
        this.jobAmount = jobAmount;
    }

    public String getJobUrl() {
        return jobUrl;
    }

    public void setJobUrl(String jobUrl) {
        this.jobUrl = jobUrl;
    }
}
