package com.zcr.behavior.chainofresponsibility;

/**
 * @author zcr
 * @date 2019/7/14-17:22
 *
 *行为型模式
 * 行为型模式关注系统中对象之间的相互交互，研究系统在运行时对象之间的相互通信和协作，进一步明确对象的职责，共有11种模式。
 * 创建型模式关注对象的创建过程。
 * 结构型模式关注对象和类的组织。
 *
 * 行为型模式汇总：
 * 责任链模式	chain of responsibility
 * 命令模式	command
 * 解释器模式	interpreter
 * 迭代器模式	iterator
 * 中介者模式	mediator
 * 备忘录模式	memento
 * 观察者模式	observer
 * 状态模式	state
 * 策略模式	strategy
 * 模板方法模式	template method
 * 访问者模式	visitor
 *
 * 责任链模式chain of responsibility
 * 定义：
 * 将能够处理同一类请求的对象连成一条链，所提交的请求沿着链传递，链上的对象逐个判断是否有能力处理该请求，如果能则处理，如果不能则传递给链上的下一个对象。
 *
 *场景：
 * 打牌时，轮流出牌
 * 接力赛跑
 * 大学中，奖学金审批
 * 公司中，公文审批
 *
 *
 *
 *
 *
 *添加新的处理对象：
 * 由于责任链的创建完全在客户端，因此新增新的具体处理者对原有类库没有任何影响，只需添加新的类，然后在客户端调用时添加即可。符合开闭原则。
 *
 * 案例：
 * 我们可以在请假处理流程中，增加新的“副总经理”角色，审批大于等于10天，小于20天的请假。审批流程变为：
 * 如果请假天数小于3天，主任审批
 * 如果请假天数大于等于3天，小于10天，经理审批
 * 大于等于10天，小于20天的请假，副总经理审批
 * 如果大于等于20天，小于30天，总经理审批
 * 如果大于等于30天，提示拒绝
 *
 * 链表方式定义职责链(上一个案例)
 * 非链表方式实现职责链
 * 通过集合、数组生成职责链更加实用！实际上，很多项目中，每个具体的Handler并不是由开发团队定义的，而是项目上线后由外部单位追加的，所以使用链表方式定义COR链就很困难。
 *
 *
 *
 * 开发中常见的场景：
 * Java中，异常机制就是一种责任链模式。一个try可以对应多个catch，当第一个catch不匹配类型，则自动跳到第二个catch.
 * Javascript语言中，事件的冒泡和捕获机制。Java语言中，事件的处理采用观察者模式。
 * Servlet开发中，过滤器的链式处理
 * Struts2中，拦截器的调用也是典型的责任链模式
 */
public class Client {

    public static void main(String[] args) {

        //请求类
        //抽象领导类（属性：姓名、下一个领导 方法：设定责任链上的后继对象、处理请求的核心的业务方法）
        //具体领导类继承抽象领导类（实现请求方法【自己处理请求或者调用自己的后继对象来处理请求】）

        AbstractLeader a = new Director("张三 ");
        AbstractLeader b = new Manager("李四");
        AbstractLeader c = new GeneralManager("王五");
        //组织责任链对象的关系
        a.setNextLeader(b);
        b.setNextLeader(c);

        LeaveRequest leaveRequest = new LeaveRequest("小朱",10,"回家");
        a.handleRequest(leaveRequest);

        /**
         * 责任链的配置关系又客户端定义，可以动态去改变
         * 责任链上可以任意增加、更改
         * 新加一个副总
         */


    }
}
