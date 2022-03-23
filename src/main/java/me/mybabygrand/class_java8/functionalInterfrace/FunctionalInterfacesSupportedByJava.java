package me.mybabygrand.class_java8.functionalInterfrace;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.*;

public class FunctionalInterfacesSupportedByJava {

    public static void main(String[] args) {
        System.out.println("===== Function ======");
        //Function : param 2개
        Function<Integer, Integer> plus10 = (i) -> i+10;
        Function<Integer, Integer> multiply2 = (i) -> i*2;
        System.out.println(plus10.apply(3));
        System.out.println(plus10.andThen(multiply2).apply(1)); //plus10 and then multiply2

        System.out.println("===== BiFunction ======");
        //BiFunction : param 3개
        BiFunction<Integer, Integer, Integer> plus10AndMultiplyJ = (i, j) -> (i+10)*j;
        System.out.println(plus10AndMultiplyJ.apply(1,3));

        System.out.println("===== Consumer ======");
        //Consumer
        Consumer<Integer> printSquareValue = (i) -> System.out.println(i*i);
        printSquareValue.accept(11);

        System.out.println("===== Supplier ======");
        Supplier<String> getNowDateTime = () -> LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:SS"));
        System.out.println(getNowDateTime.get());

        System.out.println("===== Predicate ======");
        Predicate<Integer> isEven = (i) -> i%2==0;
        for (int i = 0; i < 11; i++) {
            System.out.println(i + " is "+(isEven.test(i)?"even number":"odd number"));
        }

        System.out.println("===== UnaryOperator ======");
        UnaryOperator<Integer> plus20 = (i) -> i+20;
        UnaryOperator<Integer> multiply3 = (i) -> i*3;
        System.out.println(plus20.apply(3));
        System.out.println(plus20.andThen(multiply3).apply(1));

        System.out.println("===== BinaryOperator ======");
        BinaryOperator<Integer> minus10AndMultiplyJ = (i, j) -> (i-10)*j;
        System.out.println(minus10AndMultiplyJ.apply(12,3));
    }
}
