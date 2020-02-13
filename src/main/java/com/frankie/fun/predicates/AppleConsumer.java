package com.frankie.fun.predicates;

import com.frankie.fun.lambda.Apple;

/**
 * @author: Yao Frankie
 * @date: 2020/2/11 21:40
 */
public interface AppleConsumer {
    int NUM = 10;
    void accept(Apple a);

    default String print(){
        return "l am in AppleConsumer interface.";
    }
}
