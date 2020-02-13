package com.frankie.fun.designPatterns.templateMethod;

/**
 * @author: Yao Frankie
 * @date: 2020/2/13 16:08
 */
public class ShanghaiOnlineBank extends OnlineBank{
    @Override
    void makeCustomerHappy(Customer c) {
        System.out.println("Send coupon.");
    }
}
