package com.zcr.create.builder;

/**
 * @author zcr
 * @date 2019/7/13-16:20
 *
 *建造者模式
 * 之前学的工厂模式是用来构建某一个产品或者产品族，要是涉及到组装的话。。。
 *
 * 场景：
 * – 我们要建造一个复杂的产品。
 * 比如：神州飞船,Iphone。这个复杂的产品的创建。有这样 一个问题需要处理：
 * 装配这些子组件是不是有个步骤问题?
 *
 * – 实际开发中，我们所需要的对象构建时，也非常复杂，有很多步骤需要处理时。
 *
 * 建造模式的本质：
 * – 分离了对象子组件的单独构造(由Builder来负责)和装配(由Director负责)。 从而可以构造出复杂的对象。这个模式适用于：某个对象的构建过程复杂的情况下使用。
 *
 * – 由于实现了构建和装配的解耦。不同的构建器，相同的装配，也可以做出不同的对象； 相同的构建器，不同的装配顺序也可以做出不同的对象。
 *
 * 也就是实现了构建算法、装配 算法的解耦，实现了更好的复用。
 *
 */
public class Client {

    public static void main(String[] args) {
        AirShipDirector airShipDirector = new AirShipDirectorImpl(new AirShipBuilderImpl());
        AirShip airShip = airShipDirector.directAirShip();
        System.out.println(airShip);


        /**
         * – StringBuilder类的append方法
         * – SQL中的PreparedStatement
         * – JDOM中，DomBuilder、SAXBuilder
         */
    }


}
