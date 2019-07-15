package com.zcr.structural.bridge;

/**
 * @author zcr
 * @date 2019/7/13-22:06
 */
public interface Brand {
    void sale();
}

class Lenovo implements Brand {

    @Override
    public void sale() {
        System.out.println("销售联想电脑");
    }
}

class Dell implements Brand {

    @Override
    public void sale() {
        System.out.println("销售戴尔电脑");
    }
}

class SZ implements Brand {

    @Override
    public void sale() {
        System.out.println("销售神州电脑");
    }
}
