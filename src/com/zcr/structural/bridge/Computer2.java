package com.zcr.structural.bridge;

/**
 * @author zcr
 * @date 2019/7/13-22:08
 */
public class Computer2 {

    protected Brand brand;

    public Computer2(Brand brand) {
        this.brand = brand;
    }

    public void sale() {
        this.brand.sale();
    }
}

class Desktop2 extends Computer2 {

    public Desktop2(Brand brand) {
        super(brand);
    }

    public void sale() {
        super.sale();
        System.out.println("销售台式机");
    }
}

class Laptop2 extends Computer2 {

    public Laptop2(Brand brand) {
        super(brand);
    }

    public void sale() {
        super.sale();
        System.out.println("销售笔记本机");
    }
}

class Pad2 extends Computer2 {

    public Pad2(Brand brand) {
        super(brand);
    }

    public void sale() {
        super.sale();
        System.out.println("销售平板");
    }
}
