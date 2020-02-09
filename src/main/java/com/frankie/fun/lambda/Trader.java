package com.frankie.fun.lambda;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: Yao Frankie
 * @date: 2020/2/9 11:18
 */
@Setter
@Getter
public  class Trader{

    private String name;
    private String city;

    public Trader(String n, String c){
        this.name = n;
        this.city = c;
    }

    @Override
    public String toString(){
        return "Trader:"+this.name + " in " + this.city;
    }
}