package com.frankie.fun.designPatterns.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yao Frankie
 * @date: 2020/2/13 16:37
 */
public class Sender implements Subject {

    List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void notifyObservers(String message) {
        observers.forEach(o -> o.notify(message));
    }
}
