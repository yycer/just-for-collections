package com.frankie.fun.designPatterns.Observer;

/**
 * @author: Yao Frankie
 * @date: 2020/2/13 16:35
 */
public class AllRoundObserver implements Observer{
    @Override
    public void notify(String message) {
        if (message.contains("Java") || message.contains("Python")){
            System.out.println("AllRoundObserver got it, thanks.");
        }
    }
}
