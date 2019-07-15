package com.zcr.behavior.templatemethod;

/**
 * @author zcr
 * @date 2019/7/14-21:31
 *
 *模板方法模式 template method
 * 场景：
 * 客户到银行办理业务：
 * 取号排队
 * 办理具体现金/转账/企业/个人/理财业务
 * 给银行工作人员评分
 *
 *
 *
 *
 * 模板方法模式介绍：
 * 模板方法模式是编程中经常用得到模式。它定义了一个操作中的算法骨架，将某些步骤延迟到子类中实现。这样，新的子类可以在不改变一个算法结构的前提下重新定义该算法的某些特定步骤。
 *
 * 核心：
 * 处理某个流程的代码已经都具备，但是其中某个节点的代码暂时不能确定。
 * 因此，我们采用工厂方法模式，将这个节点的代码实现转移给子类完成。
 * 即：处理步骤父类中定义好，具体实现延迟到子类中定义
 *
 *结构都是一样的，只有我自己这个业务方法不一样
 * 通过抽象方法来进行不同的具体实现
 *
 *
 *
 *
 * 抽象模板方法：定义普通方法和抽象的业务方法，定义处理方法用于调用普通方法和业务方法实现完整的流程。
 * 具体业务子类：实现抽象模板方法，实现具体的业务类。更多的是采用匿名内部类的形式来实现这个业务方法，就不需要再额外定义这个子类了。
 *
 *
 *
 *在软件开发中，我们可以将call翻译为调用。
 * 子类不能调用父类，而通过父类调用子类。这些调用步骤已经在父类中写好了，完全由父类控制整个过程。
 *
 *
 *
 * 什么时候用到模板方法模式：
 * 实现一个算法时，整体步骤很固定。但是，某些部分易变。
 *
 * 易变部分可以抽象成出来，供子类实现。
 *
 * 开发中常见的场景：
 * 非常频繁。各个框架、类库中都有他的影子。比如常见的有：
 * 数据库访问的封装
 * Junit单元测试
 * servlet中关于doGet/doPost方法调用
 * Hibernate中模板程序
 * spring中JDBCTemplate、HibernateTemplate等。
 */
public class Client {

    public static void main(String[] args) {

        //生成不同的子类实现抽象类
        BankTemplateMethod bankTemplateMethod = new DrawMoney();
        bankTemplateMethod.process();

        //提供不同的实现！
        //更多的时候采用匿名内部类
        BankTemplateMethod bankTemplateMethod1 = new BankTemplateMethod() {
            @Override
            public void transact() {
                System.out.println("我要存钱");
            }
        };
        bankTemplateMethod1.process();

        BankTemplateMethod bankTemplateMethod2 = new BankTemplateMethod() {
            @Override
            public void transact() {
                System.out.println("我要理财");
            }
        };
        bankTemplateMethod2.process();



    }
}
