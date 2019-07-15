package com.zcr.behavior.state;

/**
 * @author zcr
 * @date 2019/7/14-21:55
 */
public class Context {

    private AbstractState state;

    public void setState(AbstractState state) {
        System.out.println("修改状态");
        this.state = state;
        state.handle();
    }
}
