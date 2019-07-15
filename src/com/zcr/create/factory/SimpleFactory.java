package com.zcr.create.factory;

/**
 * @author zcr
 * @date 2019/7/12-21:28
 *
 *单例模式：只涉及到一个类的对象创建
 *
 * factory：工厂，是用来创建对象的
 *
 * – 实现了创建者和调用者的分离。
 *
 * – 详细分类：
 * • 简单工厂模式
 * • 工厂方法模式
 * • 抽象工厂模式
 *
 * 面向对象设计的基本原则：
 * 依赖的手段是：分工
 * OCP（开闭原则，Open-Closed Principle）：一个软件的实体应当对扩展开放，对修改关闭。
 * 通过增加新的类实现，不要在这个上面进行修改
 *
 * DIP（依赖倒转原则，Dependence Inversion Principle）：要针对接口编程，不要针对实现编程。
 * a类直接调用b类，要依赖于抽象，而不要依赖于具体。b类要实现一个接口，我与接口发生关系，而不是要与实现发生关系。
 *
 * LoD（迪米特法则，Law of Demeter）：只与你直接的朋友通信，而避免和陌生人通信。
 *
 * 核心本质：
 * – 实例化对象，用工厂方法代替new操作。
 * – 将选择实现类、创建对象统一管理和控制。从而将调用者跟我们的实现类解耦。
 *
 * 工厂模式分类：
 * – 简单工厂模式 • 用来生产同一等级结构中的任意产品。（对于增加新的产品，需要修改已有代码）
 * – 工厂方法模式 • 用来生产同一等级结构中的固定产品。（支持增加任意产品）
 * – 抽象工厂模式 • 用来生产不同产品族的全部产品。（对于增加新的产品，无能为力；支持增加产品族）
 *
 */



public class SimpleFactory {

    /**
     * 简单工厂模式
     * • 要点：
     * – 简单工厂模式也叫静态工厂模式，就是工厂类一般是使用静态方法， 通过接收的参数的不同来返回不同的对象实例。
     * – 对于增加新产品无能为力！不修改代码的话，是无法扩展的。
     *
     *这违反了开闭原则，如果我们要加一个奔驰，那么我们还是需要去修改代码
     *通过多增加一个工厂类，实现了创建不同种类的汽车。
     * 这样客户端只需要与工厂类打交道就好了，工厂类去和具体的种类的车打交道。
     */
    public static Car createCar(String type) {
        if ("奥迪".equals(type)) {
            return new Audi();
        } else if ("比亚迪".equals(type)) {
            return new Byd();
        } else {
            return null;
        }
    }

}
