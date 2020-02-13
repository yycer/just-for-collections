package com.frankie.fun.designPatterns.Observer;

/**
 * @author: Yao Frankie
 * @date: 2020/2/13 16:34
 */
public class JavaObserver implements Observer {
    @Override
    public void notify(String message) {
        if (message.contains("Java")){
            System.out.println("JavaObserver got it, thanks.");
        }
    }
}
