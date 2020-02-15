package com.frankie.fun;

import com.frankie.fun.completableFuture.Discount;
import com.frankie.fun.completableFuture.Quote;
import com.frankie.fun.completableFuture.Shop;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @author: Yao Frankie
 * @date: 2020/2/15 20:21
 */
@SpringBootTest
public class CompletableFutureTest {

    public final List<Shop> shops = buildShops(8);

    public final String productName = "Mac";

    public final Executor executor = Executors.newFixedThreadPool(
            Math.min(shops.size(), 100),
            r -> {
                Thread thread = new Thread(r);
                thread.setDaemon(true);
                return thread;
            });


    @Test
    public void randomTest(){
        Random random = new Random();
        double randomDouble = random.nextDouble();

        String name = "yyc";
        char c = name.charAt(0);
        double v = randomDouble * c;
        double v1 = v + name.charAt(1);
        System.out.println(randomDouble * c);
    }

    @Test
    public void getPriceAsyncTest(){
        LocalDateTime step1 = LocalDateTime.now();
        Shop jd = new Shop("JD");
        Future<String> macFuturePrice = jd.getPriceAsync("Mac");
        LocalDateTime step2 = LocalDateTime.now();
        System.out.println("Invocation returned after " + Duration.between(step1, step2).toMillis() + " ms.");

        try {
//            String price = macFuturePrice.get();
            String price = macFuturePrice.get(2, TimeUnit.SECONDS);
            System.out.println("Price is " + price);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
        LocalDateTime step3 = LocalDateTime.now();
        System.out.println("Price returned after " + Duration.between(step1, step3).toMillis() + " ms.");
    }

    @Test
    public void getAllPriceTest(){

        LocalDateTime start = LocalDateTime.now();
//        getAllPrice();        // Using 4003 ms
        getAllPriceUsingPS(); // Using 1004 ms
//        getAllPriceUsingCF();   // Using 1004 ms
        LocalDateTime end = LocalDateTime.now();
        System.out.println("Using " + Duration.between(start, end).toMillis() + " ms");
    }


    public List<String> getAllPrice(){
        return shops.stream()
                .map(s -> String.format("%s:%s", productName, s.getPrice(productName)))
                .collect(Collectors.toList());
    }

    /**
     * getAllPriceUsingParallelStream
     */
    public List<String> getAllPriceUsingPS(){
        return shops.parallelStream()
                .map(s -> String.format("%s:%s", productName, s.getPrice(productName)))
                .collect(Collectors.toList());
    }

    /**
     * getAllPriceUsingCompletableFuture
     */
    public List<String> getAllPriceUsingCF(){
        List<CompletableFuture<String>> futurePriceList = shops.stream()
                .map(s -> CompletableFuture
                        .supplyAsync(() -> String.format("%s:%s", productName, s.getPrice(productName)), executor))
                .collect(Collectors.toList());

        List<String> priceList = futurePriceList.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());

        return priceList;
    }

    @Test
    public void multiInvocationTest(){
        LocalDateTime start = LocalDateTime.now();
//        getMultiInvocation();
        getMultiInvocationUsingCF();
        LocalDateTime end = LocalDateTime.now();
        System.out.println("Using " + Duration.between(start, end).toMillis() + " ms");
    }

    public List<String> getMultiInvocation() {
        return shops.stream()
                .map(shop -> shop.getPrice(productName))
                .map(Quote::buildQuote)
                .map(Discount::applyDiscount)
                .collect(Collectors.toList());
    }

    public List<String> getMultiInvocationUsingCF() {
        List<CompletableFuture<String>> futurePriceList = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() ->
                        shop.getPrice(productName), executor))
                .map(future -> future.thenApply(Quote::buildQuote))
                .map(future -> future.thenCompose(quote ->
                        CompletableFuture.supplyAsync(() ->
                                Discount.applyDiscount(quote), executor)))
                .collect(Collectors.toList());

        return futurePriceList.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

    public List<Shop> buildShops(int num){
        ArrayList<Shop> shops = new ArrayList<>();
        int i = 0;
        while (i < num){
            shops.add(new Shop(String.valueOf(i)));
            i++;
        }
        return shops;
    }

    @Test
    public void test(){
        String s = "10.22";
        double d = Double.parseDouble(s);
        double v = d * 0.8;
        System.out.println(d);
    }
}
