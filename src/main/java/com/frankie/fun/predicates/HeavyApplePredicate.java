package com.frankie.fun.predicates;

import com.frankie.fun.lambda.Apple;

/**
 * @author: Yao Frankie
 * @date: 2020/2/11 20:56
 */
public class HeavyApplePredicate implements ApplePredicate {
    @Override
    public boolean test(Apple a) {
        return a.getWeight() > 150;
    }
}
