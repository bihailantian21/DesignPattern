package com.zcr.behavior.observer;

/**
 * @author zcr
 * @date 2019/7/15-17:13
 */
public class Subject extends AbstractSubject{

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        //目标对象值发生了变化，请通知所有的观察者
        this.notifyAllObservers();
    }
}
