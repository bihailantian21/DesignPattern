package com.zcr.behavior.mediator;

/**
 * @author zcr
 * @date 2019/7/14-19:04
 */
public interface AbstractMediator {

    void register(String dname,AbstractDepartment d);

    void command(String dname);
}
