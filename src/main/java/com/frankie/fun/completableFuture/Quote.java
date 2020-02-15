package com.frankie.fun.completableFuture;

import lombok.Getter;

/**
 * @author: Yao Frankie
 * @date: 2020/2/15 22:25
 */
@Getter
public class Quote {

    private String price;

    public Quote(String price){
        this.price = price;
    }

    public static Quote buildQuote(String price){
        return new Quote(price);
    }
}
