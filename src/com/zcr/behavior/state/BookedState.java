package com.zcr.behavior.state;

/**
 * @author zcr
 * @date 2019/7/14-21:53
 */
public class BookedState implements AbstractState {
    @Override
    public void handle() {
        System.out.println("房间已预订，别人不能订");
    }
}
