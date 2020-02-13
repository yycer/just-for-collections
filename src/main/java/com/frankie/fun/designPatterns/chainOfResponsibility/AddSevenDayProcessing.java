package com.frankie.fun.designPatterns.chainOfResponsibility;

import java.time.LocalDate;

/**
 * @author: Yao Frankie
 * @date: 2020/2/13 18:47
 */
public class AddSevenDayProcessing extends ProcessingLocalDate<LocalDate> {

    @Override
    protected LocalDate handleWork(LocalDate input) {
        return input.plusDays(7);
    }
}
