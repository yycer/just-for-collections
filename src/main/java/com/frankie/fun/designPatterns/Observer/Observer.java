package com.frankie.fun.designPatterns.Observer;

/**
 * @author: Yao Frankie
 * @date: 2020/2/13 16:33
 */
public interface Observer {

    /**
     * @param message: 通知候选人的信息。
     */
    void notify(String message);
}
