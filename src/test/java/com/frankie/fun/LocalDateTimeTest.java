package com.frankie.fun;

import com.frankie.fun.dateAndTime.NextWorkingDay;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

/**
 * @author: Yao Frankie
 * @date: 2020/2/12 21:54
 */
@SpringBootTest
public class LocalDateTimeTest {


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
        String dtStr1 = "2020-02-13 11:22:33";
        LocalDateTime parsedDt1 = LocalDateTime
                .parse(dtStr1, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("parsedDt1 = " + parsedDt1);

        // "20200213091122" -> 2020-02-13T09:11:22
        String dtStr2 = "20200213091122";
        LocalDateTime parsedDt2 = LocalDateTime
                .parse(dtStr2, DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        System.out.println("parsedDt2 = " + parsedDt2);


        // Step2: LocalDateTime -> String
        // 2020-02-13T11:22:33  -> "2020-02-13 11:22:33"
        String formattedDt1 = parsedDt1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("formattedDt1 = " + formattedDt1);

        // 2020-02-13T09:11:22  -> "20200213091122"
        String formattedDt2 = parsedDt2.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        System.out.println("formattedDt2 = " + formattedDt2);
    }

    @Test
    public void zoneIdTest(){
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime = " + localDateTime);

        LocalDateTime utcDateTime = LocalDateTime.now(ZoneOffset.UTC);
        System.out.println("utcDateTime   = " + utcDateTime);

        ZoneId tokyoZoneId = ZoneId.of("Asia/Tokyo");
        ZonedDateTime tokyoNowByZoneId = utcDateTime.atZone(tokyoZoneId);
        System.out.println("tokyoNowByZoneId     = " + tokyoNowByZoneId);

        LocalDateTime tokyoNowByZoneOffset = LocalDateTime.now(ZoneOffset.of("+9"));
        System.out.println("tokyoNowByZoneOffset = " + tokyoNowByZoneOffset);

        ZoneId parisZoneId = ZoneId.of("Europe/Paris");
        ZonedDateTime parisDateTime = utcDateTime.atZone(parisZoneId);
        System.out.println("parisDateTime      = " + parisDateTime);

        ZoneId losAngelesZoneId = ZoneId.of("America/Los_Angeles");
        ZonedDateTime losAngelesDateTime = utcDateTime.atZone(losAngelesZoneId);
        System.out.println("losAngelesDateTime = " + losAngelesDateTime);

//        localDateTime = 2020-02-13T09:25:00.626
//        utcDateTime   = 2020-02-13T01:25:00.626
//        tokyoNowByZoneId     = 2020-02-13T01:25:00.626+09:00[Asia/Tokyo]
//        tokyoNowByZoneOffset = 2020-02-13T10:25:00.626
//        parisDateTime      = 2020-02-13T01:25:00.626+01:00[Europe/Paris]
//        losAngelesDateTime = 2020-02-13T01:25:00.626-08:00[America/Los_Angeles]

    }

    @Test
    public void durationTest() throws InterruptedException {
        LocalDateTime start = LocalDateTime.now();
        Thread.sleep(1024);
        LocalDateTime end = LocalDateTime.now();

        Duration duration = Duration.between(start, end);
        long millis = duration.toMillis();
        System.out.println("Duration is " + millis + " ms");
        // Duration is 1024 ms
    }

    @Test
    public void manipulateDateTest(){
        LocalDate date = LocalDate.of(2014, 3, 18); // 2014-03-18
        date = date.with(ChronoField.MONTH_OF_YEAR, 9); // 2014-09-18
        date = date.plusYears(2).minusDays(10); // 2016-09-08
        // Result of 'LocalDate.withYear()' is ignored
        date.withYear(2011); // 2016-09-08 [wrong]
        System.out.println(date);

        date = date.withYear(2011);
        System.out.println(date); // 2011-09-08
    }
}







