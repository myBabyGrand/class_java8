package me.mybabygrand.class_java8.completableFuture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorsApp {
    public static void main(String[] args) {
//        JobExecuteWithExecutorServiceSingle();

//        JobExecuteWithExecutorServiceFixed();

        JobExecuteWithExecutorServiceScheduled();



    }

    private static void JobExecuteWithExecutorServiceScheduled() {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(getRunnable("myBabyGrand"), 1,1, TimeUnit.SECONDS);
    }

    private static void JobExecuteWithExecutorServiceFixed() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(getRunnable("my"));
        executorService.submit(getRunnable("baby"));
        executorService.submit(getRunnable("grand"));
        executorService.submit(getRunnable("piano"));
        executorService.shutdown();
    }

    private static Runnable getRunnable(String message) {
        return () -> System.out.println(message +" "+ Thread.currentThread().getName());
    }

    private static void JobExecuteWithExecutorServiceSingle() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> {
            System.out.println("Thread " + Thread.currentThread().getName());
        });
        executorService.shutdown();
    }

}
