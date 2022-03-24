package me.mybabygrand.class_java8.functionalInterfrace;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class LambdaExpression {


    public static void main(String[] args) {
        LambdaExpression lambdaExpression = new LambdaExpression();
        lambdaExpression.run();

    }

    private void run(){
        final int baseNo = 10;

        //local class
        class LocalClass{
            void printInt1(int baseNo){
//                int baseNo = 11;
                System.out.println("===== printInt1 =====");
                System.out.println(baseNo);
                System.out.println("-----");
                for (int j = baseNo; j >0 ; j--) {
                    System.out.println(j);
                }
            }
        }
        LocalClass localClass = new LocalClass();
        localClass.printInt1(3);

        //anonymous Inner class 익명내부 클래스
        Consumer<Integer> printInt2 = new Consumer<Integer>() {
            @Override
            public void accept(Integer baseNo) {
                System.out.println("===== printInt2 =====");
                System.out.println(baseNo);
                System.out.println("-----");
                for (int j = baseNo; j >0 ; j--) {
                    System.out.println(j);
                }
            }
        };
        printInt2.accept(4);

        //Lambda
        IntConsumer printInt3 = (i) -> {
            System.out.println("===== printInt3 =====");
            System.out.println(baseNo);
            System.out.println("-----");
            for (int j = i; j >0 ; j--) {
                System.out.println(j);
            }
        };

        printInt3.accept(5);
    }

}
