package com.zcr.behavior.mediator;

/**
 * @author zcr
 * @date 2019/7/14-19:07
 */
public class FinacialDepartment implements AbstractDepartment{


    private AbstractMediator abstractMediator;//持有对中介类的引用

    public FinacialDepartment(AbstractMediator abstractMediator) {
        this.abstractMediator = abstractMediator;
        abstractMediator.register("finacial",this);
    }

    @Override
    public void selfAction() {
        System.out.println("数钱。");
    }

    @Override
    public void outAction() {
        System.out.println("哪个部门需要用钱。");
    }
}
