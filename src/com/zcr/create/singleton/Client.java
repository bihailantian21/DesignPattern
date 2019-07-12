package com.zcr.create.singleton;

/**
 * @author zcr
 * @date 2019/7/12-10:05
 */
public class Client {

    public static void main(String[] args) {

        //饿汉式
        SingletonHungry singletonHungry = SingletonHungry.getInstance();
        SingletonHungry singletonHungry1 = SingletonHungry.getInstance();
        System.out.println(singletonHungry == singletonHungry1);

        //懒汉式
        SingletonLazy singletonLazy = SingletonLazy.getInstance();
        SingletonLazy singletonLazy1 = SingletonLazy.getInstance();
        System.out.println(singletonLazy == singletonLazy1);

        //双重检测锁
        SingletonDoubleDetectionLock singletonDoubleDetectionLock = SingletonDoubleDetectionLock.getInstance();
        SingletonDoubleDetectionLock singletonDoubleDetectionLock1 = SingletonDoubleDetectionLock.getInstance();
        System.out.println(singletonDoubleDetectionLock == singletonDoubleDetectionLock1);

        //静态内部类
        SingletonStaticInnerClass singletonStaticInnerClass = SingletonStaticInnerClass.getInstance();
        SingletonStaticInnerClass singletonStaticInnerClass1 = SingletonStaticInnerClass.getInstance();
        System.out.println(singletonStaticInnerClass == singletonStaticInnerClass1);


        //枚举
    }
}
