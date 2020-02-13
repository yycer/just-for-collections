package com.frankie.fun.designPatterns.Observer;

/**
 * @author: Yao Frankie
 * @date: 2020/2/13 16:37
 */
public interface Subject {

    void registerObserver(Observer o);
    void notifyObservers(String message);
}
