package com.zcr.structural.proxy;

/**
 * @author zcr
 * @date 2019/7/13-17:09
 */
public class RealStar implements Star {
    @Override
    public void confer() {
        System.out.println("RealStar confer");
    }

    @Override
    public void signContract() {
        System.out.println("RealStar signContract");
    }

    @Override
    public void bookTicket() {
        System.out.println("RealStar bookTicket");
    }

    @Override
    public void sing() {
        System.out.println("RealStar sing");
    }

    @Override
    public void collectMoney() {
        System.out.println("RealStar collectMoney");
    }
}
