package com.zcr.behavior.command;

/**
 * @author zcr
 * @date 2019/7/14-20:35
 */
public class Invoker {

    private AbstractCommand command;//也可以通过容器容纳很多命令，进行批处理

    public Invoker(AbstractCommand command) {
        this.command = command;
    }

    //业务方法，用于调用命令类的方法
    public void call() {
        command.execute();
    }
}
