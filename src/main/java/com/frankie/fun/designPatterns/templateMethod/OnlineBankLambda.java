package com.frankie.fun.designPatterns.templateMethod;

import java.util.function.Consumer;

/**
 * @author: Yao Frankie
 * @date: 2020/2/13 16:17
 */
public class OnlineBankLambda {

    public void processCustomer(int id, Consumer<Customer> consumer){
        Customer customer = getCustomerInfoById(id);
        consumer.accept(customer);
    }

    public Customer getCustomerInfoById(int id){
        return new Customer();
    }
}
