package com.frankie.fun.completableFuture;

import java.math.BigDecimal;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * @author: Yao Frankie
 * @date: 2020/2/15 20:33
 */
public class Shop {

    public Shop(String name){

    }

    public String getPrice(String productName){
        delay();
        return getRandomPrice(productName);
    }

    public Future<String> getPriceAsync1(String productName){
        CompletableFuture<String> futurePrice = new CompletableFuture<>();
        new Thread(() -> {
            try {
                int i = 10 / 0;
                String price = getPrice(productName);
                futurePrice.complete(price);
            } catch (Exception ex){
                futurePrice.completeExceptionally(ex);
            }
        }).start();
        return futurePrice;
    }

    public Future<String> getPriceAsync(String productName){
        return CompletableFuture.supplyAsync(() -> getPrice(productName));
//        return CompletableFuture.supplyAsync(() -> {
//            int i = 10 / 0;
//            return getPrice(productName);
//        });
    }


    public static void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String getRandomPrice(String productName) {
        Random random = new Random();
        BigDecimal priceBd = BigDecimal
                .valueOf(random.nextDouble() * productName.charAt(0) + productName.charAt(1))
                .setScale(2, BigDecimal.ROUND_UP);
        return String.valueOf(priceBd);
    }
}
