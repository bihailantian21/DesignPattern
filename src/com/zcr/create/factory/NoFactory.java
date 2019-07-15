package com.zcr.create.factory;

/**
 * @author zcr
 * @date 2019/7/12-21:30
 */
public class NoFactory {


}

interface Car {
    void run();
}

class Audi implements Car {

    @Override
    public void run() {
        System.out.println("奥迪在跑");
    }
}

class Byd implements Car {

    @Override
    public void run() {
        System.out.println("比亚迪在跑");
    }
}
