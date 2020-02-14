package com.frankie.fun;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

/**
 * @author: Yao Frankie
 * @date: 2020/2/14 09:38
 */
@SpringBootTest
public class WildcardTest {

    @Test
    public void extendsTest(){
        ArrayList<? extends Number> numbers  = new ArrayList<Number>();
        ArrayList<? extends Number> integers = new ArrayList<Integer>();
        ArrayList<? extends Number> doubles  = new ArrayList<Double>();

//        // Step1: Writing
//        numbers.add();
//        integers.add(new Integer(1));
//
//        // Step2: Reading
//        integers.get()
        HashSet<Number> numbers1 = new HashSet<>();
    }

    @Test
    public void wildcardTest(){
        ArrayList<?> strings = new ArrayList<String>();
//        strings.add("a");
        strings.add(null);
    }
}
