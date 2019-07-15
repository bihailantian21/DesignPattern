package com.zcr.behavior.mediator;

/**
 * @author zcr
 * @date 2019/7/14-19:07
 */
public class DevelopmentDepartment implements AbstractDepartment{

    private AbstractMediator abstractMediator;//持有对中介类的引用

    public DevelopmentDepartment(AbstractMediator abstractMediator) {
        this.abstractMediator = abstractMediator;
        abstractMediator.register("development",this);
    }

    @Override
    public void selfAction() {
        System.out.println("专心科研，开发项目。");
    }

    @Override
    public void outAction() {
        System.out.println("汇报工作：没钱了，需要资金。");
        abstractMediator.command("finacial");
    }
}
