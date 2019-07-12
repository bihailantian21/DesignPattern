package com.zcr.create.singleton;

/**
 * @author zcr
 * @date 2019/7/12-10:01
 * static变量会在类装载时初始化，此时也不会涉及多个线程对象访问该对象的问题。虚拟机保证只会装载一次该类，肯定不会发生并发访问的问题。因此，可以省略synchronized关键字。
 * 线程安全：类加载时就创建对象，这是天然一个线程安全的情况
 * 调用效率高：方法没有加同步synchronized，调用效率高
 * 不能延时加载：static变量会在类装载时初始化
 *
 */
public class SingletonHungry {
    //1.私有化静态属性
    private static SingletonHungry instance = new SingletonHungry();

    //2.私有化构造器
    private SingletonHungry() {

    }

    //3.公共的方法
    public static SingletonHungry getInstance() {
        return instance;
    }
}
