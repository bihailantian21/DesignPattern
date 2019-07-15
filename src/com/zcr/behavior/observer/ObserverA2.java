package com.zcr.behavior.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @author zcr
 * @date 2019/7/15-17:26
 */
public class ObserverA2 implements Observer {

    private int myState;

    @Override
    public void update(Observable o, Object arg) {
        myState = ((Subject2)o).getState();
    }

    public int getMyState() {
        return myState;
    }

    public void setMyState(int myState) {
        this.myState = myState;
    }
}
