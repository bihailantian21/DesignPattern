package com.zcr.structural.flyweight;

import com.zcr.structural.decorate.AbstractCar;

/**
 * @author zcr
 * @date 2019/7/14-11:01
 */

//抽象享元类
public interface AbstractChess {
    void setColor();
    String getColor();
    void display(Coordinate c);
}

//具体享元类
class Chess implements AbstractChess {

    private String color;

    public Chess(String color) {
        this.color = color;
    }

    @Override
    public void setColor() {

    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public void display(Coordinate c) {
        System.out.println("棋子颜色" + color);
        System.out.println("棋子位置" + c.getX() + "---" + c.getY());
    }
}
