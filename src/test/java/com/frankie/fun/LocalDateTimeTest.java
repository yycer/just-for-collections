package com.frankie.fun;

import com.frankie.fun.dateAndTime.NextWorkingDay;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

/**
 * @author: Yao Frankie
 * @date: 2020/2/12 21:54
 */
@SpringBootTest
public class LocalDateTimeTest {

    @Test
    public void test1(){
        LocalDate date = LocalDate.of(2014, 3, 18);
        date = date.with(ChronoField.MONTH_OF_YEAR, 9);
        date = date.plusYears(2).minusDays(10);
        LocalDate result = date.withYear(2011);

        System.out.println(date);
    }

    @Test
    public void nextWorkingDayTest(){

        // 周一: 20200210
        LocalDate monday = LocalDate.of(2020, 2, 10);
        LocalDate r1 = monday.with(new NextWorkingDay());
        System.out.println(r1); // 2020-02-11

        // 周四: 20200213
        LocalDate thursday = LocalDate.of(2020, 2, 13);
        LocalDate r2 = thursday.with(new NextWorkingDay());
        System.out.println(r2); // 2020-02-14

        // 周五: 20200214
        LocalDate friday = LocalDate.of(2020, 2, 14);
        LocalDate r3 = friday.with(new NextWorkingDay());
        System.out.println(r3); // 2020-02-17

        // 周六: 20200215
        LocalDate saturday = LocalDate.of(2020, 2, 15);
        LocalDate r4 = saturday.with(new NextWorkingDay());
        System.out.println(r4); // 2020-02-17

        // 周天: 20200216
        LocalDate sunday = LocalDate.of(2020, 2, 16);
        LocalDate r5 = sunday.with(new NextWorkingDay());
        System.out.println(r5); // 2020-02-17
    }

    @Test
    public void dateTimeFormatterTest(){
        // Step1: String -> LocalDateTime
        // "2020-02-13 11:22:33" -> 2020-02-13T11:22:33
        String dateTimeStr = "2020-02-13 11:22:33";
        LocalDateTime parsedDateTime = LocalDateTime
                .parse(dateTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("parsedDateTime       = " + parsedDateTime);

        // Step2: LocalDateTime -> String
        // 2020-02-13T11:22:33  -> "2020-02-13 11:22:33"
        LocalDateTime dateTime = LocalDateTime.of(2020, 2, 13, 11, 22, 33);
        String formattedDateTimeStr = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("formattedDateTimeStr = " + formattedDateTimeStr);

//        parsedDateTime       = 2020-02-13T11:22:33
//        formattedDateTimeStr = 2020-02-13 11:22:33

        LocalDateTime now = LocalDateTime.now();
        String yyyyMMddHHmmss = now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        System.out.println(yyyyMMddHHmmss);
    }
}







