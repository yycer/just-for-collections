package com.frankie.fun.predicates;

import com.frankie.fun.lambda.Apple;

/**
 * @author: Yao Frankie
 * @date: 2020/2/11 20:54
 */
public class GreenApplePredicate implements ApplePredicate {
    @Override
    public boolean test(Apple a) {
        System.out.println(this);
        return "green".equals(a.getColor());
    }
}
