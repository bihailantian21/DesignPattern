package com.zcr.behavior.state;

/**
 * @author zcr
 * @date 2019/7/14-21:46
 *
 *状态模式 state
 * 场景：
 * 电梯的运行
 * 维修、正常、自动关门、自动开门、向上运行、向下运行、消防状态
 *
 * 红绿灯
 * 红灯、黄灯、绿灯
 *
 * 企业或政府系统
 * 公文的审批状态
 * 报销单据审批状态
 * 假条审批
 *
 * 网上购物时，订单的状态
 * 下单
 * 已付款
 * 已发货
 * 送货中
 * 已收货
 *
 *
 *
 * 案例
 * 场景：
 * 酒店系统中，房间的状态变化：
 * 已预订
 * 已入住
 * 空闲
 *
 *
 *
 *
 * 核心：
 * 用于解决系统中复杂对象的状态转换以及不同状态下行为的封装问题
 *
 * 结构：
 * Context环境类 状态类作为属性，通过set方法传递参数的形式传入状态类。
 * 并且在设置状态的方法中调用状态类的handle方法来切换状态。
 * 环境类中维护一个State对象，他是定义了当前的状态。维持不同状态之间的切换。持有不同的状态作为引用
 *
 * State抽象状态类 定义了handle方法
 *
 * ConcreteState具体状态类 实现了抽象状态类，重写了handle方法。
 * 每一个类封装了一个状态对应的行为
 *
 *
 *开发中常见的场景：
 * 银行系统中账号状态的管理
 * OA系统中公文状态的管理
 * 酒店系统中，房间状态的管理
 * 线程对象各状态之间的切换
 *
 *
 */
public class Client {

    public static void main(String[] args) {

        Context context = new Context();
        context.setState(new FreeState());
        context.setState(new BookedState());

    }
}
