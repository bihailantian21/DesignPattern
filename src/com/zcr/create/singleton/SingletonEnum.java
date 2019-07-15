package com.zcr.create.singleton;

/**
 * @author zcr
 * @date 2019/7/12-10:21
 * 优点：
 * – 实现简单
 * – 枚举本身就是单例模式。由JVM从根本上提供保障！避免通过反射和反序列化的漏洞！
 * 缺点：
 * – 无延迟加载
 */
public enum SingletonEnum {

    //定义一个枚举的元素，它就代表了单例的一个实例.这个枚举元素，本身就是单例对象！
    INSTANCE;

    //单例可以有自己的操作.添加自己需要的操作！
    public void singletonOperation() {

    }



}
