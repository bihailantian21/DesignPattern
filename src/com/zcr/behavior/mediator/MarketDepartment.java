package com.zcr.behavior.mediator;

/**
 * @author zcr
 * @date 2019/7/14-19:07
 */
public class MarketDepartment implements AbstractDepartment{

    private AbstractMediator abstractMediator;//持有对中介类的引用

    public MarketDepartment(AbstractMediator abstractMediator) {
        this.abstractMediator = abstractMediator;
        abstractMediator.register("market",this);
    }

    @Override
    public void selfAction() {
        System.out.println("接项目");
    }

    @Override
    public void outAction() {
        System.out.println("项目承接进度，需要资金。");
        abstractMediator.command("finacial");
    }
}
