package me.mybabygrand.class_java8.completableFuture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorsApp {
    public static void main(String[] args) throws InterruptedException {
        JobExecuteWithExecutorServiceSingle();
        JobExecuteWithExecutorServiceFixed();
        JobExecuteWithExecutorServiceScheduled();
    }

    private static void JobExecuteWithExecutorServiceScheduled() throws InterruptedException {
        System.out.println("===JobExecuteWithExecutorServiceScheduled===");
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(getRunnable("myBabyGrand"), 1,1, TimeUnit.SECONDS);
        Thread.sleep(3000);
        scheduledExecutorService.shutdown();
    }

    private static void JobExecuteWithExecutorServiceFixed() {
        System.out.println("===JobExecuteWithExecutorServiceFixed===");

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
        System.out.println("===JobExecuteWithExecutorServiceSingle===");
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> {
            System.out.println("Thread " + Thread.currentThread().getName());
        });
        executorService.shutdown();
    }

}
