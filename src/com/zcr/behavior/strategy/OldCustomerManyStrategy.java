package com.zcr.behavior.strategy;

/**
 * @author zcr
 * @date 2019/7/14-20:58
 */
public class OldCustomerManyStrategy implements Strategy {
    @Override
    public double getPrice(double standardPrice) {
        System.out.println("打八折");
        return standardPrice * 0.8;
    }
}
