package com.frankie.fun.completableFuture;

import java.math.BigDecimal;

/**
 * @author: Yao Frankie
 * @date: 2020/2/15 22:25
 */
public class Discount {

    public static String applyDiscount(Quote quote){
        Shop.delay();
        BigDecimal priceBd = BigDecimal.valueOf(Double.parseDouble(quote.getPrice()) * 0.8)
                .setScale(2, BigDecimal.ROUND_UP);
        return String.valueOf(priceBd);
    }
}
