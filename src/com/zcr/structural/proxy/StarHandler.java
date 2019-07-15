package com.zcr.structural.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zcr
 * @date 2019/7/13-17:35
 */
public class StarHandler implements InvocationHandler {
    //动态代理类只能代理接口（不支持抽象类），代理类都需要实现InvocationHandler类，实现invoke方法。
    // 该invoke方法就是调用被代理接口的所有方法时需要调用的，该invoke方法返回的值是被代理接口的一个实现类

    // 目标对象
    Star realStar;

    public StarHandler(Star realStar) {
        this.realStar = realStar;
    }
/*
    传入目标对象参数的第二种方法：
    被代理对象realStar通过参数传递进来，我们通过realStar.getClass().getClassLoader()获取ClassLoader对象，
    然后通过realStar.getClass().getInterfaces()获取它实现的所有接口，
    然后将realStar包装到实现了InvocationHandler接口的StarHandler对象中。
    通过newProxyInstance函数我们就获得了一个动态代理对象。
    //绑定关系，也就是关联到哪个接口（与具体的实现类绑定）的哪些方法将被调用时，执行invoke方法。
    public Object newProxyInstance(Object realStar){
        this.realStar=realStar;
        //该方法用于为指定类装载器、一组接口及调用处理器生成动态代理类实例
        //第一个参数指定产生代理对象的类加载器，需要将其指定为和目标对象同一个类加载器
        //第二个参数要实现和目标对象一样的接口，所以只需要拿到目标对象的实现接口
        //第三个参数表明这些被拦截的方法在被拦截时需要执行哪个InvocationHandler的invoke方法
        //根据传入的目标返回一个代理对象
        return Proxy.newProxyInstance(realStar.getClass().getClassLoader(),
                realStar.getClass().getInterfaces(),this);
    }*/



    /**
     *java.lang.reflect.InvocationHandler(处理器接口)：
     *          * 可以通过invoke方法实现对真实角色的代理访问；
     *          * 每次通过Proxy生成代理类对象时都要指定对应的处理器对象
     */

    //关联的这个实现类的方法被调用时将被执行
    /*InvocationHandler接口的方法，proxy表示代理，method表示原对象被调用的方法，args表示方法的参数*/
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //method.invoke(realStar,args);
        Object object = null;
        /*原对象方法调用前处理日志信息*/
        System.out.println("真正的方法执行前：");
        System.out.println("面谈，签合同，订机票");

        //调用目标方法
        if (method.getName().equals("sing")) {
            object = method.invoke(realStar,args);
        }

        /*原对象方法调用后处理日志信息*/
        System.out.println("真正的方法执行后：");
        System.out.println("收钱");

        return object;
    }
}
