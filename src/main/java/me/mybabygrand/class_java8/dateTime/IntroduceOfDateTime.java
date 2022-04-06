package me.mybabygrand.class_java8.dateTime;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class IntroduceOfDateTime {
    public static void main(String[] args) throws InterruptedException {
        //mutable하기 때문에 thread safe하지 않다.
        Date date = new Date();
        long time = date.getTime();
        System.out.println(date);
        System.out.println(time);

        Thread.sleep(1000*3);

        Date dateAfter3S = new Date();
        System.out.println(dateAfter3S);
        dateAfter3S.setTime(time);
        System.out.println(dateAfter3S);


        System.out.println("=========");
        //버그를 유발하는 경우가 많다
        //생일이 1986.03.15 인 경우 아래와 같이 하면 1986.04.15라고 기록됨됨
        Calendar birthday = new GregorianCalendar(1986, 3, 15);
        System.out.println(birthday.getTime());

        Calendar realBirthday = new GregorianCalendar(1986, Calendar.MARCH, 15);
        System.out.println(realBirthday.getTime());
    }
}
