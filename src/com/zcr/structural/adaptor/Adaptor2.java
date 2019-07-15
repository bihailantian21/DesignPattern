package com.zcr.structural.adaptor;

/**
 * @author zcr
 * @date 2019/7/13-21:51
 *
 * 使用对象组合的方式实现
 */
public class Adaptor2 implements Usb {

    private Key key;

    public Adaptor2(Key key) {
        this.key = key;
    }

    @Override
    public void UseKey() {
        this.key.print();
    }
}
