package com.frankie.fun.completableFuture;

import java.math.BigDecimal;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author: Yao Frankie
 * @date: 2020/2/15 20:33
 */
public class Shop {

    public static final Random random = new Random();

    public Shop(String name){

    }

    public String getPrice(String productName){
        randomDelay();
        return getRandomPrice(productName);
    }

    public Future<String> getPriceUsingFuture(String productName){
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        Future<String> future = cachedThreadPool
                .submit(() -> {
                    int i = 10 / 0;
                    return getPrice(productName);
                });
        return future;
    }


    public Future<String> getPriceAsync1(String productName){
        CompletableFuture<String> futurePrice = new CompletableFuture<>();
        new Thread(() -> {
            try {
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

    public static void randomDelay(){
        int delay = 500 + Shop.random.nextInt(1000);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String getRandomPrice(String productName) {

        BigDecimal priceBd = BigDecimal
                .valueOf(random.nextDouble() * productName.charAt(0) + productName.charAt(1))
                .setScale(2, BigDecimal.ROUND_UP);
        return String.valueOf(priceBd);
    }
}
