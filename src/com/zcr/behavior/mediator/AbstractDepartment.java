package com.zcr.behavior.mediator;

/**
 * @author zcr
 * @date 2019/7/14-19:05
 */
public interface AbstractDepartment {

    void selfAction();//做本部门的事情
    void outAction();//向总经理发出申请
}
