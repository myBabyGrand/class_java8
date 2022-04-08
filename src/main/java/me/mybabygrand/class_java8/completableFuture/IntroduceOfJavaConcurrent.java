package me.mybabygrand.class_java8.completableFuture;

import java.time.LocalDateTime;

public class IntroduceOfJavaConcurrent {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=====Sample====");
        threadSample();

        System.out.println("=====Sleep====");
        System.out.println("start threadSleep "+LocalDateTime.now());
        threadSleep();
        System.out.println("end threadSleep "+LocalDateTime.now());

        Thread.sleep(2000L);

        System.out.println("=====interrupt====");
        System.out.println("start threadInterrupt "+LocalDateTime.now());
        threadInterrupt();
        System.out.println("end threadInterrupt "+LocalDateTime.now());

        System.out.println("=====join====");
        System.out.println("start threadJoin "+LocalDateTime.now());
        threadJoin();
        System.out.println("end threadJoin "+LocalDateTime.now());
    }
    static class HelloThread extends Thread {
        @Override
        public void run() {
            System.out.println("HelloThread() " + Thread.currentThread().getName());
        }
    }

    private static void threadSample() {
        HelloThread helloThread = new HelloThread();
        helloThread.start();
        System.out.println("hello : " + Thread.currentThread().getName());
    }

    private static void threadJoin() throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("threadJoin() : "+Thread.currentThread().getName());
            try {
                Thread.sleep(6000L);
            } catch (InterruptedException e) {
                throw new IllegalArgumentException();
            }

        });
        thread.start();
        System.out.println("hello : "+Thread.currentThread().getName());
        thread.join();
        System.out.println(thread +"is finished");
    }

    private static void threadInterrupt() throws InterruptedException {
        Thread thread = new Thread(() -> {
            while(true){
                try {
                    System.out.println("threadInterrupt() : "+Thread.currentThread().getName());
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException occurred. exit!");
                    return;
                }
            }
        });
        thread.start();
        System.out.println("hello : "+Thread.currentThread().getName());
        Thread.sleep(5000L);
        thread.interrupt();
    }

    private static void threadSleep() {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("threadSleep() : "+Thread.currentThread().getName());
        });
        thread.start();
        System.out.println("hello : "+Thread.currentThread().getName());
        System.out.println(thread +"is finished");
    }


}
