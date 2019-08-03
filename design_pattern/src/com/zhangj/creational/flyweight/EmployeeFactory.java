package com.zhangj.creational.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangj
 * @date 2019/8/3
 */
public class EmployeeFactory {
    private final static Map<String, Employee> EMPLOYEE_MAP = new HashMap<>();

    public static Manager getManager(String department) {
        Manager manager = (Manager) EMPLOYEE_MAP.get(department);
        if (manager == null) {
            manager = new Manager(department);
            System.out.print("创建部门经理:" + department);
            String reportContent = department + "部门汇报:此次报告的主要内容是......";
            manager.setReportContent(reportContent);
            System.out.println(" 创建报告:" + reportContent);
            EMPLOYEE_MAP.put(department, manager);
        }
        return manager;
    }
}
