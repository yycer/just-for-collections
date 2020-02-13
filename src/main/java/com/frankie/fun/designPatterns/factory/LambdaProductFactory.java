package com.frankie.fun.designPatterns.factory;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @author: Yao Frankie
 * @date: 2020/2/13 21:01
 */
public class LambdaProductFactory {

    public static Map<String, Supplier<Product>> products = new HashMap<>();

    static {
        products.put("loan",  Loan::new);
        products.put("stock", Stock::new);
        products.put("bond",  Bond::new);
    }

    public static Product createProduct(String name){
        Supplier<Product> p = products.get(name);
        if (p == null) throw new RuntimeException("Failed to create product by " + name);
        return p.get();
    }
}
