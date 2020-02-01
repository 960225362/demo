package com.example.demo.huyue.design.yuanxing;

/**
 * @author huyue01@sinovatech.com 2019/10/6 14:17
 */
public class WorkExperience implements Cloneable {
    private String workDate;
    private String company;

    public WorkExperience(String workDate, String company) {
        this.workDate = workDate;
        this.company = company;
    }

    public String getWorkDate() {
        return workDate;
    }

    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
