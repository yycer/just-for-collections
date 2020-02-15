package com.frankie.fun;

import com.frankie.fun.completableFuture.Shop;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author: Yao Frankie
 * @date: 2020/2/15 20:21
 */
@SpringBootTest
public class CompletableFutureTest {

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
}
