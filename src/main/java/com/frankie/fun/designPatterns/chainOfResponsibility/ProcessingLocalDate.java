package com.frankie.fun.designPatterns.chainOfResponsibility;

/**
 * @author: Yao Frankie
 * @date: 2020/2/13 18:43
 */
public abstract class ProcessingLocalDate<T> {

    public ProcessingLocalDate<T> successor;

    public void setSuccessor(ProcessingLocalDate<T> successor){
        this.successor = successor;
    }

    public T handle(T input){
        T r = handleWork(input);
        if (successor != null){
            return successor.handle(r);
        }
        return r;
    }

    abstract protected T handleWork(T input);
}
