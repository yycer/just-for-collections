package com.frankie.fun.designPatterns.factory;

/**
 * @author: Yao Frankie
 * @date: 2020/2/13 20:55
 */
public class TraditionalProductFactory {

    public static Product createProduct(String name){
        switch (name){
            case "loan":  return new Loan();
            case "stock": return new Stock();
            case "bond":  return new Bond();
            default: throw new RuntimeException("Fail to create product by " + name);
        }
    }
}
