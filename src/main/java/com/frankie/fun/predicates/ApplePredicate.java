package com.frankie.fun.predicates;

import com.frankie.fun.lambda.Apple;

/**
 * @author: Yao Frankie
 * @date: 2020/2/11 20:53
 */
public interface ApplePredicate {
    /**
     * @param a 元素值
     * @return 是否满足谓词条件
     */
    boolean test(Apple a);
}
