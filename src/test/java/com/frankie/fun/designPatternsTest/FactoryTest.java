package com.frankie.fun.designPatternsTest;

import com.frankie.fun.designPatterns.factory.LambdaProductFactory;
import com.frankie.fun.designPatterns.factory.Product;
import com.frankie.fun.designPatterns.factory.TraditionalProductFactory;
import org.junit.jupiter.api.Test;

/**
 * @author: Yao Frankie
 * @date: 2020/2/13 20:58
 */
public class FactoryTest {

    @Test
    public void traditionalFactoryTest(){
        Product stock = TraditionalProductFactory.createProduct("stock");
        Product loan  = TraditionalProductFactory.createProduct("loan");
        stock.PrintName();
        loan.PrintName();
    }

    @Test
    public void lambdaFactoryTest(){
        Product stock = LambdaProductFactory.createProduct("stock");
        Product loan = LambdaProductFactory.createProduct("loan");
        stock.PrintName(); // My name is stock.
        loan.PrintName();  // My name is loan.
    }
}
