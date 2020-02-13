package com.frankie.fun.designPatterns.strategy;

import com.frankie.fun.lambda.Apple;

/**
 * @author: Yao Frankie
 * @date: 2020/2/13 15:34
 */
public interface ValidAppleStrategy {

    /**
     * @param a: Apple
     */
    boolean valid(Apple a);
}
