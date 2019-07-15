package com.zcr.behavior.chainofresponsibility;

/**
 * @author zcr
 * @date 2019/7/14-17:26
 */
public abstract class AbstractLeader {

    protected String name;
    protected AbstractLeader nextLeader;//责任链上的后继对象

    public AbstractLeader(String name) {
        this.name = name;
    }

    //设定责任链上的后继对象
    public void setNextLeader(AbstractLeader nextLeader) {
        this.nextLeader = nextLeader;
    }

    //处理请求的核心的业务方法
    public abstract void handleRequest(LeaveRequest request);


    /**
     * 抽象类、接口、继承的不同点
     * 抽象类：不能被初始化的类
     * 接口：用于实现多重继承
     */
}
