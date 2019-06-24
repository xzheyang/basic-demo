package com.hy.basic.java.grammar.java8features;

import java.time.*;

/**
 * @user hy
 * @date sometime
 * @introduce            新日期
 **/
public class NewDate {

    public static void main(String args[]){
        NewDate java8tester = new NewDate();
        java8tester.testLocalDateTime();
    }

    /*
            LocalDateTime   包含日期时间
            LocalDate       只有日期
            LocalTime       只有时间
     */
    public void testLocalDateTime(){

        // 获取当前的日期时间
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("当前时间: " + currentTime);

        //转换为LocalDate
        LocalDate date1 = currentTime.toLocalDate();
        System.out.println("date1: " + date1);

        System.out.println("date1推前5天: " + date1.plusDays(-5L));

        Month month = currentTime.getMonth();
        int day = currentTime.getDayOfMonth();
        int seconds = currentTime.getSecond();

        System.out.println("月: " + month +", 日: " + day +", 秒: " + seconds);

        LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
        System.out.println("date2: " + date2);

        // 12 december 2014
        LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
        System.out.println("date3: " + date3);

        // 22 小时 15 分钟
        LocalTime date4 = LocalTime.of(22, 15);
        System.out.println("date4: " + date4);

        // 解析字符串
        LocalTime date5 = LocalTime.parse("20:15:30");
        System.out.println("date5: " + date5);



    }

    /*
            支持时区
     */
    public void testZonedDateTime(){

        // 获取当前时间日期
        ZonedDateTime date1 = ZonedDateTime.parse("2015-12-03T10:15:30+05:30[Asia/Shanghai]");
        System.out.println("date1: " + date1);

        ZoneId id = ZoneId.of("Europe/Paris");
        System.out.println("ZoneId: " + id);

        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println("当期时区: " + currentZone);
    }

}
