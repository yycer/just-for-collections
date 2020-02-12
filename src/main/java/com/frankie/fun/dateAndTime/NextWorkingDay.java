package com.frankie.fun.dateAndTime;

import java.time.DayOfWeek;
import java.time.temporal.*;

/**
 * @author: Yao Frankie
 * @date: 2020/2/12 22:04
 */
public class NextWorkingDay implements TemporalAdjuster {
    @Override
    public Temporal adjustInto(Temporal temporal) {
        DayOfWeek dayOfWeek = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
        int plusDays = 1;
        if (dayOfWeek.equals(DayOfWeek.FRIDAY)) plusDays = 3;
        else if (dayOfWeek.equals(DayOfWeek.SATURDAY)) plusDays = 2;
        return temporal.plus(plusDays, ChronoUnit.DAYS);
    }
}
