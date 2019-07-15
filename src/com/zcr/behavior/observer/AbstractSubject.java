package com.zcr.behavior.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zcr
 * @date 2019/7/15-17:09
 */
public class AbstractSubject {

    protected List<AbstractObserver> list = new ArrayList<AbstractObserver>();

    public void registerObserver(AbstractObserver observer) {
        list.add(observer);
    }

    public void removeObserver(AbstractObserver observer) {
        list.remove(observer);
    }

    //通知所有观察者更新状态
    public void notifyAllObservers() {
        for (AbstractObserver observer : list) {
            observer.update(this);
        }
    }
}
