package com.zcr.create.singleton;


import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * @author zcr
 * @date 2019/7/12-10:12
 *
 * 测试懒汉式单例模式(如何防止反射和反序列化漏洞)
 *
 */
public class SingletonLazy2 implements Serializable {

    //1.私有化静态属性（只是声明，而不去初始化对象）
    private static SingletonLazy2 instance;

    //2.私有化构造器
    private SingletonLazy2(){
        //通过手动抛出异常，避免通过反射创建多个单例对象！防止通过反射来调用这个！！即多次调用的时候抛出异常
        if (instance != null) {
            throw new RuntimeException("只能创建一个对象");
        }

    }

    //3.公有化方法（只在第一次调用的时候初始化对象）
    public synchronized static SingletonLazy2 getInstance() {
        if (instance == null) {
            instance = new SingletonLazy2();
        }
        return instance;
    }

    //反序列化时，如果对象所在类定义了readResolve()，实际是一种回调，定义返回哪个对象
    //反序列化时，如果定义了readResolve()则直接返回此方法指定的对象。而不需要单独再创建新对象！
    private Object readResolve() throws ObjectStreamException {
        return instance;
    }
}
