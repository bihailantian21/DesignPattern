package com.zcr.behavior.chainofresponsibility;

/**
 * @author zcr
 * @date 2019/7/14-17:24
 *
 *场景：
 * 公司里面，报销个单据需要经过流程：
 * 申请人填单申请，申请给经理
 * 小于1000，经理审查。
 * 超过1000，交给总经理审批。
 * 总经理审批通过
 *
 * 公司里面，请假条的审批过程：
 * 如果请假天数小于3天，主任审批
 * 如果请假天数大于等于3天，小于10天，经理审批
 * 如果大于等于10天，小于30天，总经理审批
 * 如果大于等于30天，提示拒绝
 *
 * 公司里面，SCM(Supply Chain Management供应链管理)系统中，采购审批子系统的设计：
 * 采购金额小于5万，主任审批
 * 采购金额大于等于5万，小于10万，经理审批
 * 采购金额大于等于10万，小于20万，副总经理审批
 * 采购金额大于等于20万，总经理审批
 *
 * 请假条审批流程案例
 *
 * 请假请求
 * 领导抽象类，具体的人实现这个领导抽象类。主任、经理、总经理
 * 属性：姓名、下一个领导
 * 方法：设置下一个领导、处理请求
 *
 */
public class LeaveRequest {

    private String empName;
    private int leaveDays;
    private String reason;

    public LeaveRequest(String empName, int leaveDays, String reason) {
        this.empName = empName;
        this.leaveDays = leaveDays;
        this.reason = reason;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getLeaveDays() {
        return leaveDays;
    }

    public void setLeaveDays(int leaveDays) {
        this.leaveDays = leaveDays;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
