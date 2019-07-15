package com.zcr.behavior.state;

/**
 * @author zcr
 * @date 2019/7/14-21:53
 */
public class CheckedInState implements AbstractState {
    @Override
    public void handle() {
        System.out.println("房间已入住，请勿打扰");
    }
}
