package me.mybabygrand.class_java8.dateTime;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateTimeAPI {
    public static void main(String[] args) {
        System.out.println("=====machine time=====");
        Instant machineNow = Instant.now();
        System.out.println(machineNow);//기준시각(그리니치 천문대)
        System.out.println(machineNow.atZone(ZoneId.of("UTC")));//GMT시각
        ZonedDateTime machineZonedDateTime = machineNow.atZone(ZoneId.systemDefault());
        System.out.println(machineZonedDateTime);

        System.out.println("=====human time=====");
        LocalDateTime humanNow = LocalDateTime.now();
        System.out.println(humanNow);
        LocalDateTime birthDayDateTime = LocalDateTime.of(1986, Month.MARCH, 15, 6, 30, 05);
        System.out.println(birthDayDateTime);
        ZonedDateTime humanZonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println(humanZonedDateTime);

        System.out.println("=====Period=====");
        LocalDate from = LocalDate.now();
        LocalDate christmas = LocalDate.of(2022, Month.DECEMBER, 25);
        Period remainToChristmas = Period.between(from, christmas);
        System.out.println(remainToChristmas.getYears()+"years "
                          +remainToChristmas.getMonths()+"months "
                          +remainToChristmas.getDays()+"days remain");

        Period remainToChristmas2 = from.until(christmas);
        System.out.println(remainToChristmas2.getYears()+"years "
                +remainToChristmas2.getMonths()+"months "
                +remainToChristmas2.getDays()+"days remain");

        System.out.println("=====Duration=====");
        Instant to = machineNow.plus(10, ChronoUnit.SECONDS);
        Duration between = Duration.between(machineNow, to);
        System.out.println(between.getSeconds());

        System.out.println("=====Formatting=====");
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatterMMDdYyyy = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(now.format(formatterMMDdYyyy));

        LocalDate parse = LocalDate.parse("03/15/1986", formatterMMDdYyyy);
        System.out.println(parse);

        System.out.println("=====Supporting Legacy API=====");
        //from legacy
        //date
        Date date = new Date();
        Instant instant = date.toInstant();
        System.out.println(instant);
        //calendar
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        ZonedDateTime zoneGregorianCalendar = gregorianCalendar.toInstant().atZone(ZoneId.systemDefault());
        LocalDateTime localDateTime = zoneGregorianCalendar.toLocalDateTime();
        System.out.println(zoneGregorianCalendar);
        System.out.println(localDateTime);
        //Timezone
        ZoneId zoneId = TimeZone.getDefault().toZoneId();
        System.out.println(zoneId);

        //to legacy
        //date
        Date newDate = Date.from(instant);
        System.out.println(newDate);
        //calendar
        GregorianCalendar newGregorianCalendar = GregorianCalendar.from(zoneGregorianCalendar);
        System.out.println(newGregorianCalendar);
        //Timezone
        TimeZone newTimeZone = TimeZone.getTimeZone(zoneId);
        System.out.println(newTimeZone);
    }
}
