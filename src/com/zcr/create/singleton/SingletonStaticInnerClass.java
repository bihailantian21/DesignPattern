package com.zcr.create.singleton;

/**
 * @author zcr
 * @date 2019/7/12-10:20
 *
 * 线程安全：只有真正调用getInstance(),才会加载静态内部类。加载类时是线程安全的。
 * instance是static final 类型，保证了内存中只有这样一个实例存在，而且只能被赋值一次，从而保证了线程安全性.
 * 调用效率高：方法没有加同步synchronized，调用效率高
 * 延时加载：第一次加载静态内部类时并不会去创建对象，而是调用方法后才会创建
 * 在内部类被加载和初始化时，才创建实例对象；静态内部类不会自动随着外部类的加载和初始化而初始化，它是要单独去加载和初始化的
 */
public class SingletonStaticInnerClass {

    //1.静态内部类中定义静态属性，私有化静态属性
    private static class StaticInnerClass {
        private static final SingletonStaticInnerClass instance = new SingletonStaticInnerClass();
    }

    //2.私有化构造方法
    private SingletonStaticInnerClass() {

    }

    //3.公有化方法
    public static SingletonStaticInnerClass getInstance() {
        return StaticInnerClass.instance;
    }



}


