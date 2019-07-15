package com.zcr.create.singleton;

import java.io.Serializable;

/**
 * @author zcr
 * @date 2019/7/12-10:12
 * 线程安全：加了synchronized方法
 * 调用效率低：方法加了同步synchronized，并发效率低
 * 延时加载：真正用的时候才去加载
 *
 */
public class SingletonLazy implements Serializable {

    //1.私有化静态属性（只是声明，而不去初始化对象）
    private static SingletonLazy instance;

    //2.私有化构造器
    private SingletonLazy() {

    }

    //3.公有化方法（只在第一次调用的时候初始化对象）
    public synchronized static SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }
}
