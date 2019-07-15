package com.zcr.behavior.strategy;

/**
 * @author zcr
 * @date 2019/7/14-20:53
 *
 * 假如，类型特别多，算法比较复杂时，整个条件控制代码会变得很长，难于维护。
 */
public class NoStrategy {

    public double getPrice(String type,double price) {

        if (type.equals("普通客户小批量")) {
            System.out.println("不打折，原价");
            return price;
        } else if (type.equals("普通客户大批量")) {
            System.out.println("打九折");
            return price * 0.9;
        } else if (type.equals("老客户小批量")) {
            System.out.println("打八五折");
            return price * 0.85;
        } else if (type.equals("老客户大批量")) {
            System.out.println("打八折");
            return price * 0.8;
        }
        return price;
    }
}
