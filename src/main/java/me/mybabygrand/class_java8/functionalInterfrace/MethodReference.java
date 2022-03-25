package me.mybabygrand.class_java8.functionalInterfrace;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class MethodReference {
    public static void main(String[] args) {
        //static method 참조 | type::static method
        UnaryOperator<String> hi = Greeting::hi;
        System.out.println("=====static method type=====");
        System.out.println(hi.apply("Gundam"));//이때 생성

        //특정 객체 instance method참조 | 객체 레퍼런스::instance method
        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;
        System.out.println("=====특정 객체 instance method참조=====");
        System.out.println(hello.apply("RX-78-2"));

        //임의 객체 instance method참조 | type::instance method
        String [] singleMolts ={"Glenfiddich", "Balvenie", "Macallan"};
        /**
         * Arrays.sort(singleMolts, new Comparator<String>() {
         *             @Override
         *             public int compare(String o1, String o2) {
         *                 return 0;
         *             }
         *         });
         * */
        Arrays.sort(singleMolts, String::compareToIgnoreCase);
        System.out.println("=====임의 객체 instance method참조=====");
        for (String singleMolt : singleMolts) {
            System.out.println(singleMolt);
        }

        //constructor 참조 | type::new
        Supplier<Greeting> greetingSupplier = Greeting::new;
        Greeting getGreeting1 = greetingSupplier.get();//이때 생성됨
        System.out.println("=====constructor(매개변수없음) 참조=====");
        System.out.println(getGreeting1.getName());
        getGreeting1.setName("Amuro");
        System.out.println(getGreeting1.getName());

        //constructor 참조 | type::new
        Function<String, Greeting> greetingFunction = Greeting::new;
        Greeting getGreeting2 = greetingFunction.apply("Ray");//이때 생성
        System.out.println("=====constructor(매개변수있음) 참조=====");
        System.out.println(getGreeting2.getName());

    }
}

class Greeting{
    private String name;

    public Greeting() {
    }

    public Greeting(String name) {
        this.name = name;
    }

    public String hello(String name){
        return "hello "+ name;
    }

    public static String hi (String name){
        return "hi "+name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
