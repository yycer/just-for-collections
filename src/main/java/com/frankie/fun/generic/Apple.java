package com.frankie.fun.generic;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: Yao Frankie
 * @date: 2020/2/14 14:36
 */
@Setter
@Getter
public class Apple<T extends Number> {

    private T size;

    public Apple(T size){
        this.size = size;
    }
}
