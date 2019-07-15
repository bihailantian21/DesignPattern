package com.zcr.behavior.strategy;

/**
 * @author zcr
 * @date 2019/7/14-20:52
 *
 *
 *策略模式 strategy
 * 场景：
 * 某个市场人员接到单后的报价策略(CRM系统中常见问题)。报价策略很复杂，可以简单作如下分类：
 * 普通客户小批量报价
 * 普通客户大批量报价
 * 老客户小批量报价
 * 老客户大批量报价
 *
 * 具体选用哪个报价策略，这需要根据实际情况来确定。这时候，我们采用策略模式即可。
 *
 * 我们先可以采用条件语句处理：实现起来比较容易，
 * 符合一般开发人员的思路
 *
 *
 *
 * 策略模式
 * 策略模式对应于解决某一个问题的一个算法族，允许用户从该算法族中任选一个算法解决某一问题，
 * 同时可以方便的更换算法或者增加新的算法。并且由客户端决定调用哪个算法。
 *
 * 抽象策略类 定义计算价格的方法。
 * 具体策略类，实现策略算法类，实现计算价格的方法。每一个算法对应一个独立的算法类，实现了同一个接口，对外统一提供服务
 * 上下文类，用来管理算法。这里设置算法的引用。上下文类，指向了具体的算法的引用，替换引用即可。负责与具体的策略类交互
 * 将策略类作为一个属性，通过构造方法传递参数的形式传入策略类。并且在输出价格方法中调用策略类的计算价格的方法。
 *
 *本质：
 * 分离算法，选择实现。
 *
 * 开发中常见的场景：
 * JAVASE中GUI编程中，布局管理
 * Spring框架中，Resource接口，资源访问策略
 * javax.servlet.http.HttpServlet#service()
 */
public class Client {

    public static void main(String[] args) {

        Strategy strategy = new OldCustomerFewStrategy();
        Context context = new Context(strategy);
        context.printPrice(998);

    }
}
