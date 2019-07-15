package com.zcr.create.factory;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * @author zcr
 * @date 2019/7/12-21:28
 */
public class AbstractFactory {

    /**
     *• 抽象工厂模式
     * – 用来生产不同产品族的全部产品。（对于增加新的产品，无能为力； 支持增加产品族）
     * – 抽象工厂模式是工厂方法模式的升级版本，在有多个业务品种、业务分类时，通过抽象工厂模式产生需要的对象是一种非常好的解决方式。
     *
     * 高端产品—产品族
     * 中端产品
     * 低端产品
     *
     * 之前的：创建一个car接口下的不同子类
     * 要创建多个接口的子类怎么办？
     * 需要使用抽象工厂
     *
     * 针对发动机
     *
     *
     *
     */
}

interface Engine {
    void run();
    void start();
}

class LuxuryEngine implements Engine {

    @Override
    public void run() {
        System.out.println("转的快！");
    }

    @Override
    public void start() {
        System.out.println("启动快！可以自动启停！");
    }
}

class LowEngine implements Engine {

    @Override
    public void run() {
        System.out.println("转的慢！");
    }

    @Override
    public void start() {
        System.out.println("启动慢！");
    }
}

interface Seat {
    void message();
}

class LuxurySeat implements Seat {

    @Override
    public void message() {
        System.out.println("可以自动按摩");
    }
}

class LowSeat implements Seat {

    @Override
    public void message() {
        System.out.println("不能按摩");
    }
}

interface Tyre {
    void revolve();
}

class LuxuryTyre implements Tyre {

    @Override
    public void revolve() {
        System.out.println("旋转不磨损");
    }
}

class LowTyre implements Tyre {

    @Override
    public void revolve() {
        System.out.println("旋转耐磨");
    }
}

interface ACarFactory {
    Engine createEngine();
    Seat createSeat();
    Tyre createTyre();
}

class LuxuryACarFactory implements ACarFactory {

    @Override
    public Engine createEngine() {
        return new LuxuryEngine();
    }

    @Override
    public Seat createSeat() {
        return new LuxurySeat();
    }

    @Override
    public Tyre createTyre() {
        return new LuxuryTyre();
    }
}

class LowACarFactory implements ACarFactory {

    @Override
    public Engine createEngine() {
        return new LowEngine();
    }

    @Override
    public Seat createSeat() {
        return new LowSeat();
    }

    @Override
    public Tyre createTyre() {
        return new LowTyre();
    }
}

