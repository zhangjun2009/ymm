package com.zhangj.creational.flyweight;

/**
 * @author zhangj
 * @date 2019/8/3
 */
public class Manager implements Employee {
    private String department;
    private String reportContent;

    public Manager(String department) {
        this.department = department;
    }

    @Override
    public void report() {
        System.out.println(reportContent);
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }
}
