package com.frankie.fun.designPatternsTest;

import com.frankie.fun.designPatterns.templateMethod.BeijingOnlineBank;
import com.frankie.fun.designPatterns.templateMethod.OnlineBankLambda;
import com.frankie.fun.designPatterns.templateMethod.ShanghaiOnlineBank;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: Yao Frankie
 * @date: 2020/2/13 16:10
 */
@SpringBootTest
public class TemplateMethodTest {

    @Test
    public void test(){
        new ShanghaiOnlineBank().processCustomer(1); // Send coupon.
        new BeijingOnlineBank().processCustomer(2);  // Lottery.
    }

    @Test
    public void lambdaTest(){
        new OnlineBankLambda().processCustomer(1, c -> System.out.println("Send coupon.")); // Send coupon.
        new OnlineBankLambda().processCustomer(2, c -> System.out.println("Lottery."));     // Lottery.
    }
}
