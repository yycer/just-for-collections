package com.frankie.fun.designPatterns.Observer;

/**
 * @author: Yao Frankie
 * @date: 2020/2/13 16:35
 */
public class PythonObserver implements Observer {
    @Override
    public void notify(String message) {
        if (message.contains("Python")){
            System.out.println("PythonObserver got it, thanks.");
        }
    }
}
