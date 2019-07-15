package com.zcr.structural.appearance;

/**
 * @author zcr
 * @date 2019/7/14-10:44
 *
 * 外观模式 facade
 * 迪米特法则(最少知识原则)：
 * 一个软件实体应当尽可能少的与其他实体发生相互作用。
 *
 * 外观模式核心：
 * 为子系统提供统一的入口。封装子系统的复杂性，便于客户端调用。
 *
 *
 *
 * 开发中常见的场景
 * 频率很高。哪里都会遇到。各种技术和框架中，都有外观模式的使用。如：
 * JDBC封装后的，commons提供的DBUtils类，Hibernate提供的工具类、Spring JDBC工具类等
 *
 *
 */
public class Client {

    public static void main(String[] args) {
//        工商局 a = new 海淀区工商局();
//        a.checkName();
//        税务局 b= new 海淀区税务局();
//        b.taxCertificate();
//        银行 c = new 中国工商银行();
//        c.openAccount();

        //使用一个类把其他类的并列功能全部实现
        new RegisterFacade().register();

    }
}
