package com.frankie.fun.designPatterns.templateMethod;

import java.util.function.Consumer;

/**
 * @author: Yao Frankie
 * @date: 2020/2/13 16:04
 */
public abstract class OnlineBank {

    public void processCustomer(int id){
        Customer customer = getCustomerInfoById(id);
        makeCustomerHappy(customer);
    }

    abstract void makeCustomerHappy(Customer c);

    public Customer getCustomerInfoById(int id){
        return new Customer();
    }
}
