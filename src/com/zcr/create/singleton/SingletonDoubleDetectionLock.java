package com.zcr.create.singleton;

/**
 * @author zcr
 * @date 2019/7/12-10:20
 * 之前懒汉式在方法前面设置了同步，
 * 这个模式将同步内容下方到if内部，提高了执行的效率不必每次获取对象时都进行同步，只有第一次才同步，创建了以后就没必要了。
 * 问题： 由于编译器优化原因和JVM底层内部模型原因， 偶尔会出问题。不建议使用。
 */
public class SingletonDoubleDetectionLock {

    //1.私有化静态属性（只是声明，而不去初始化对象）
    private static SingletonDoubleDetectionLock instance;

    //2.私有化构造器
    private SingletonDoubleDetectionLock() {

    }

    //3.公有化方法（只在第一次调用的时候初始化对象）
    public static SingletonDoubleDetectionLock getInstance() {
        if (instance == null) {
            synchronized(SingletonDoubleDetectionLock.class) {
                if (instance == null) {
                    synchronized (SingletonDoubleDetectionLock.class) {
                        instance = new SingletonDoubleDetectionLock();
                    }
                }
            }
        }
        return instance;
    }
}
