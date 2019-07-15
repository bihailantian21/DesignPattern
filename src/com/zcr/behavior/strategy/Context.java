package com.zcr.behavior.strategy;

/**
 * @author zcr
 * @date 2019/7/14-21:01
 *
 * 上下文类，用来管理算法
 * 这里设置算法的引用
 * 负责与具体的策略类交互
 *
 *
 * 可以通过构造器注入
 * 也可以通过set方法来注入
 * 如果使用spring的依赖注入功能的话，还可以通过配置文件，动态的注入不同的策略对象，动态的切换不同算法
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void printPrice(double s) {
        System.out.println("您该报价：" + strategy.getPrice(s));
    }
}
