package com.zcr.behavior.observer;

import java.util.Observable;

/**
 * @author zcr
 * @date 2019/7/15-17:23
 */
public class Subject2 extends Observable {

    private int state;

    public void set(int s) {
        state = s;//目标对象的状态发生了变化

        setChanged();//表示目标对象已经做了修改
        notifyObservers(state);//通知所有观察者
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
