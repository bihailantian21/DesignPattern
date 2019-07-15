package com.zcr.behavior.observer;

/**
 * @author zcr
 * @date 2019/7/15-17:15
 */
public class ObserverA implements AbstractObserver {

    private int myState;//要与目标对象的状态值保持一致

    @Override
    public void update(AbstractSubject subject) {
        myState = ((Subject)subject).getState();
    }

    public int getMyState() {
        return myState;
    }

    public void setMyState(int myState) {
        this.myState = myState;
    }
}
