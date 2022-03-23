package me.mybabygrand.class_java8.functionalInterfrace;

public class SamInterfaceImpl {

    public static void main(String[] args) {

        /**
         SamInterface samInterface = new SamInterface(){

            @Override
            public void doSomething() {
            System.out.println("Do Something!");

            }
        };
         * */
        //anonymous Inner class
        SamInterface samInterface = () -> System.out.println("Do Something!");
        System.out.println("******");
        samInterface.doSomething();
        System.out.println("======");

        /**
        SamInterface samInterface_1 = new SamInterface(){

            @Override
            public void doSomething() {
                System.out.println("Do");
                System.out.println("Something!");
            }
        };
         */
        SamInterface samInterface_1 = () -> {
            System.out.println("Do");
            System.out.println("Something!");
        };

        SamInterface2 samInterface2 = new SamInterface2() {
            @Override
            public int getDoubleValue(int input) {
                return input*2;
            }
        };

    }
}
