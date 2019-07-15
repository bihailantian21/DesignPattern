package com.zcr.behavior.iterator;

/**
 * @author zcr
 * @date 2019/7/14-18:30
 *
 *迭代器模式 iterator
 * 场景：
 * 提供一种可以遍历聚合对象的方式。又称为：游标cursor模式
 * 聚合对象：存储数据
 * 迭代器：遍历数据
 *
 * 结构：
 * 聚合对象：存储数据
 * 迭代器：遍历数据
 *
 * 迭代抽象类：接口。用于定义得到开始对象、得到下一个对象、判断是否存在下一个对象、判断是否是开头、是否到达结尾、获取当前对象等抽象方法，统一接口
 * 具体迭代类：继承迭代抽象类。定义游标、定义聚集类作为属性，通过构造函数传递聚集类。实现上述各种方法。
 * 聚集抽象类：定义创建迭代的方法。
 * 具体聚集类：继承聚集抽象类。定义容器属性，定义增删改查对象到列表中的方法、实现创建迭代的方法
 *
 *
 *
 * 开发中常见的场景
 * JDK内置的迭代器(List/Set),实现了iterator接口
 *
 *
 */
public class Client {

    public static void main(String[] args) {

        Aggregate aggregate = new Aggregate();
        aggregate.addObject("aa");
        aggregate.addObject("bb");
        aggregate.addObject("cc");

        AbstractIterator abstractIterator = aggregate.createIterator();
        while (abstractIterator.hasNext()) {
            System.out.println(abstractIterator.getCurrentObj());
            abstractIterator.next();
        }
    }
}
