package com.frankie.fun.generic;

import java.util.Stack;

/**
 * @author: Yao Frankie
 * @date: 2020/2/14 15:43
 */
public class MyStack<E> extends Stack<E> {

    public void pushAll(Iterable<? extends E> src){
        for (E e: src){
            push(e);
        }
    }
}
