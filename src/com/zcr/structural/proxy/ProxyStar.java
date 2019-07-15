package com.zcr.structural.proxy;

/**
 * @author zcr
 * @date 2019/7/13-17:09
 */
public class ProxyStar implements Star {

    // 目标对象
    private Star star;

    // 通过构造方法传入目标对象
    public ProxyStar(Star star) {
        this.star = star;
    }

    @Override
    public void confer() {
        System.out.println("ProxyStar confer");
    }

    @Override
    public void signContract() {
        System.out.println("ProxyStar signContract");
    }

    @Override
    public void bookTicket() {
        System.out.println("ProxyStar bookTicket");
    }

    @Override
    public void sing() {
        //添加打印日志的功能
        System.out.println("sing start");
        star.sing();
        System.out.println("sing end");
    }

    @Override
    public void collectMoney() {
        System.out.println("ProxyStar collectMoney");
    }
}
