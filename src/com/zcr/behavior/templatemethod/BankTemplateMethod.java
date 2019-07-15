package com.zcr.behavior.templatemethod;

/**
 * @author zcr
 * @date 2019/7/14-21:36
 */
public abstract class BankTemplateMethod {

    public void takeNumber() {
        System.out.println("取号排队");
    }

    public abstract void transact();//办理具体的业务

    public void evaluate() {
        System.out.println("反馈评分");
    }

    public final void process() {
        this.takeNumber();
        this.transact();
        this.evaluate();
    }
}
