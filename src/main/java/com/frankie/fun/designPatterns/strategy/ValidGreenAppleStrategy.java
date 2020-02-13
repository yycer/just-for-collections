package com.frankie.fun.designPatterns.strategy;

import com.frankie.fun.lambda.Apple;

/**
 * @author: Yao Frankie
 * @date: 2020/2/13 15:35
 */
public class ValidGreenAppleStrategy implements ValidAppleStrategy {
    @Override
    public boolean valid(Apple a) {
        return "green".equals(a.getColor());
    }
}
