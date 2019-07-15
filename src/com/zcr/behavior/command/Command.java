package com.zcr.behavior.command;

import com.zcr.structural.flyweight.AbstractChess;

/**
 * @author zcr
 * @date 2019/7/14-20:31
 */
public class Command implements AbstractCommand {

    private Receiver receiver;//命令真正的执行者

    public Command(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        //命令真正执行前或后，执行相关的处理
        receiver.action();
    }
}
