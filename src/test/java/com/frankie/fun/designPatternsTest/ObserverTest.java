package com.frankie.fun.designPatternsTest;

import com.frankie.fun.designPatterns.Observer.AllRoundObserver;
import com.frankie.fun.designPatterns.Observer.JavaObserver;
import com.frankie.fun.designPatterns.Observer.PythonObserver;
import com.frankie.fun.designPatterns.Observer.Sender;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: Yao Frankie
 * @date: 2020/2/13 16:39
 */
@SpringBootTest
public class ObserverTest {

    @Test
    public void test(){
        Sender sender = new Sender();
        sender.registerObserver(new JavaObserver());
        sender.registerObserver(new PythonObserver());
        sender.registerObserver(new AllRoundObserver());
        sender.notifyObservers("l have a Java job!");

//        JavaObserver got it, thanks.
//        AllRoundObserver got it, thanks.
    }

}
