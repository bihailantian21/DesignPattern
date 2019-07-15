package com.zcr.structural.adaptor;

/**
 * @author zcr
 * @date 2019/7/13-19:46
 *
 * 缺点：java是单继承，不够灵活
 * 所以是类适配器的是实现方式
 */
public class Adaptor extends Key implements Usb{
    @Override
    public void UseKey() {
        super.print();
    }
}
