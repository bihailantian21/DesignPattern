package com.zcr.behavior.strategy;

/**
 * @author zcr
 * @date 2019/7/14-20:58
 */
public class NewCustomerFewStrategy implements Strategy {
    @Override
    public double getPrice(double standardPrice) {
        System.out.println("不打折，原价");
        return standardPrice;
    }
}
