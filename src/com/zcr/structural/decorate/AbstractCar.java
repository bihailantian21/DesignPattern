package com.zcr.structural.decorate;

/**
 * @author zcr
 * @date 2019/7/14-9:55
 *
 */

//抽象构件
public interface AbstractCar {
    void move();
}

//具体构件
class Car implements AbstractCar {

    @Override
    public void move() {
        System.out.println("陆地上跑");
    }
}

//装饰角色
// 持有真实对象的引用    构造器构造的时候传进来
class SuperCar implements AbstractCar {
    private AbstractCar abstractCar;

    public SuperCar(AbstractCar abstractCar) {
        this.abstractCar = abstractCar;
    }

    @Override
    public void move() {
        abstractCar.move();
    }
}


//具体装饰角色
class FlyCar extends SuperCar {

    public FlyCar(AbstractCar abstractCar) {
        super(abstractCar);
    }

    public void fly() {
        System.out.println("天上飞！");
    }

    @Override
    public void move() {
        super.move();
        fly();
    }
}

class WaterCar extends SuperCar {

    public WaterCar(AbstractCar abstractCar) {
        super(abstractCar);
    }

    public void swim() {
        System.out.println("水上游！");
    }

    @Override
    public void move() {
        super.move();
        swim();
    }
}

class AICar extends SuperCar {

    public AICar(AbstractCar abstractCar) {
        super(abstractCar);
    }

    public void autoMove() {
        System.out.println("天上飞！");
    }

    @Override
    public void move() {
        super.move();
        autoMove();
    }
}
