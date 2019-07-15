package com.zcr.create.singleton;

import java.io.ObjectInputStream;
import java.util.concurrent.CountDownLatch;

/**
 * @author zcr
 * @date 2019/7/12-10:05
 */
public class Client {

    public static void main(String[] args) throws Exception{

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
        SingletonEnum singletonEnum = SingletonEnum.INSTANCE;
        SingletonEnum singletonEnum1 = SingletonEnum.INSTANCE;
        System.out.println(singletonEnum == singletonEnum1);


        //常见的五种单例模式在多线程环境下的效率测试
        /**
         * 懒汉式加了同步
         *
         * CountDownLatch
         * – 同步辅助类，在完成一组正在其他线程中执行的操作之前，它允许一个或多个线程一直等待。
         * • countDown() 当前线程调此方法，则计数减一(建议放在 finally里执行)
         * • await()， 调用此方法会一直阻塞当前线程，直到计时器的值为0
         */
        long start = System.currentTimeMillis();
        int threadNum = 10;
        final CountDownLatch countDownLatch = new CountDownLatch(threadNum);//并发时的一个同步辅助类

        for (int i = 0; i < threadNum; i++) {//启动了10个线程
            new Thread(new Runnable() {//匿名内部类
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {//每个线程中把每个方法调用了1万次
                        Object o = SingletonLazy.getInstance();//依次测试
                    }
                    countDownLatch.countDown();
                }
            }).start();
        }

        countDownLatch.await();//main线程阻塞，直到计数器变为0，才会继续往下执行！其实就是循环检测
        //为什么要加上CountDownLatch ？是为了等待几个线程全部执行完，要不然main方法一下执行完了，统计的是main方法的时间
        long end = System.currentTimeMillis();
        System.out.println("总耗时："+(end - start));

        /**
         * 常见的五种单例模式实现方式及选用
         * – 主要：
         * • 饿汉式（线程安全，调用效率高。 但是，不能延时加载。）
         * • 懒汉式（线程安全，调用效率不高。 但是，可以延时加载。）
         * – 其他：
         * • 双重检测锁式（由于JVM底层内部模型原因，偶尔会出问题。不建议使用） 对应于懒汉式！！！
         * • 静态内部类式(线程安全，调用效率高。 但是，可以延时加载)  ***********     》 懒汉式
         * • 枚举式(线程安全，调用效率高，不能延时加载。并且可以天然的防止反射和反序列 化漏洞！)  ********  》 饿汉式
         *
         * 如何选用?
         * – 单例对象 占用资源少，不需要延时加载：
         * • 枚举式 好于 饿汉式
         * – 单例对象 占用资源大，需要延时加载：
         * • 静态内部类式 好于 懒汉式
         */

    }
}
