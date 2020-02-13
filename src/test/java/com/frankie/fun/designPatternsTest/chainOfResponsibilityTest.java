package com.frankie.fun.designPatternsTest;

import com.frankie.fun.designPatterns.chainOfResponsibility.AddSevenDayProcessing;
import com.frankie.fun.designPatterns.chainOfResponsibility.AddSevenMonthProcessing;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * @author: Yao Frankie
 * @date: 2020/2/13 18:19
 */
@SpringBootTest
public class chainOfResponsibilityTest {

    @Test
    public void commonProcessTest(){
        LocalDate date20080101 = LocalDate.of(2008, 1, 1);
        LocalDate date20180801 = date20080101.plusMonths(7);
        LocalDate date20080808 = date20180801.plusDays(7);
    }

    @Test
    public void chainTest(){
        LocalDate date20080101 = LocalDate.of(2008, 1, 1);
        AddSevenMonthProcessing addSevenMonthProcessing = new AddSevenMonthProcessing();
        AddSevenDayProcessing   addSevenDayProcessing   = new AddSevenDayProcessing();
        addSevenMonthProcessing.setSuccessor(addSevenDayProcessing);

        LocalDate result = addSevenMonthProcessing.handle(date20080101);
        System.out.println(result); // 2008-08-08
    }

    @Test
    public void lambdaTest(){
        LocalDate date20080101 = LocalDate.of(2008, 1, 1);
        UnaryOperator<LocalDate> addSevenMonth = ld -> ld.plusMonths(7);
        UnaryOperator<LocalDate> addSevenDay   = ld -> ld.plusDays(7);

        Function<LocalDate, LocalDate> pipeline = addSevenMonth.andThen(addSevenDay);
        LocalDate result = pipeline.apply(date20080101);
        System.out.println(result); // 2008-08-08

    }

}
