package com.frankie.fun.lambda;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author: Yao Frankie
 * @date: 2020/2/12 14:29
 */
@Setter
@Getter
public class Order {

    private String orderId;
    private BigDecimal amount;

    public Order(String orderId, BigDecimal amount){
        this.orderId = orderId;
        this.amount = amount;
    }

    @Override
    public String toString(){
        return "Order{" +
                "orderId=" + orderId + '\'' +
                ", count=" + amount +
                "}";
    }

}
