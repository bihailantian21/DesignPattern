package com.zcr.structural.bridge;

/**
 * @author zcr
 * @date 2019/7/13-22:00
 *
 *
 *问题：
 * 扩展性问题(类个数膨胀问题)：
 * 如果要增加一个新的电脑类型:智能手机，则要增加各个品牌下面的类。
 * 如果要增加一个新的品牌，也要增加各种电脑类型的类。
 *
 * 违反单一职责原则：
 * 每个类都承担了两个职责，违反了单一职责原则，承担了品牌和类型
 * 一个类：联想笔记本，有两个引起这个类变化的原因
 *
 */
public interface Computer {
    void sale();
}

class Desktop implements Computer {

    @Override
    public void sale() {
        System.out.println("销售台式机");
    }
}

class Laptop implements Computer {

    @Override
    public void sale() {
        System.out.println("销售笔记本");
    }
}

class Pad implements Computer {

    @Override
    public void sale() {
        System.out.println("销售平板");
    }
}








class LenovoDesktop extends Desktop {

    @Override
    public void sale() {
        System.out.println("销售联想台式机");
    }
}

class LenovoLaptop extends Laptop {

    @Override
    public void sale() {
        System.out.println("销售联想笔记本");
    }
}

class LenovoPad extends Pad {

    @Override
    public void sale() {
        System.out.println("销售联想平板");
    }
}












class DellDesktop extends Desktop {

    @Override
    public void sale() {
        System.out.println("销售戴尔台式机");
    }
}

class DellLaptop extends Laptop {

    @Override
    public void sale() {
        System.out.println("销售戴尔笔记本");
    }
}

class DellPad extends Pad {

    @Override
    public void sale() {
        System.out.println("销售戴尔平板");
    }
}