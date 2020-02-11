package com.frankie.fun.lambda;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: Yao Frankie
 * @date: 2020/2/11 20:35
 */
@Setter
@Getter
public class Apple {
    private int    weight;
    private String color;

    public Apple(int weight, String color){
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}
