package com.zcr.create.factory;

import java.text.SimpleDateFormat;

/**
 * @author zcr
 * @date 2019/7/12-21:35
 */
public class Client {

    public static void main(String[] args) {

        //没有使用工厂（）
        Car c1 = new Audi();
        Car c2 = new Byd();
        c1.run();
        c2.run();

        //简单工厂（对于增加新产品无能为力！不修改代码的话，是无法扩展的。）
        Car c3 = SimpleFactory.createCar("奥迪");
        Car c4 = SimpleFactory.createCar("比亚迪");
        c3.run();
        c4.run();

        //工厂方法（支持增加产品，可扩展）
        Car c5 = new AudiFactory().createCar();
        Car c6 = new BydFactory().createCar();
        c5.run();
        c6.run();

        //抽象工厂
        ACarFactory factory = new LuxuryACarFactory();
        Engine e = factory.createEngine();
        e.run();
        e.start();

        /**
         * 工厂模式要点：
         * – 简单工厂模式(静态工厂模式)
         * • 虽然某种程度不符合设计原则，但实际使用最多。
         *
         * – 工厂方法模式
         * • 不修改已有类的前提下，通过增加新的工厂类实现扩展。
         *
         * – 抽象工厂模式
         * • 不可以增加产品，可以增加产品族！
         *
         * • 应用场景
         * – JDK中Calendar的getInstance方法
         * – JDBC中Connection对象的获取
         * – Hibernate中SessionFactory创建Session
         * – spring中IOC容器创建管理bean对象
         * – XML解析时的DocumentBuilderFactory创建解析器对象
         * – 反射中Class对象的newInstance()
         */


    }
}
