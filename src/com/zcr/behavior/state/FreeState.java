package com.zcr.behavior.state;

import com.zcr.behavior.command.AbstractCommand;

import java.sql.Statement;

/**
 * @author zcr
 * @date 2019/7/14-21:53
 */
public class FreeState implements AbstractState {
    @Override
    public void handle() {
        System.out.println("房间空闲，没人住");
    }
}
