package com.zcr.behavior.templatemethod;

/**
 * @author zcr
 * @date 2019/7/14-21:38
 */
public class DrawMoney extends BankTemplateMethod {
    @Override
    public void transact() {
        System.out.println("我要取款！");
    }
}
