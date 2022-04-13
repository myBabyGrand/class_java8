package me.mybabygrand.class_java8.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFuture1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        JobExecuteWithCompletableFuture();
        JobExecuteWithCompletableFutureAsync();
        JobExecuteWithCompletableFutureSupplyAsync();
        JobExecuteWithCompletableFutureCallBackThenApply();
        JobExecuteWithCompletableFutureCallBackThenAccept();
        JobExecuteWithCompletableFutureCallBackThenRun();

    }

    private static void JobExecuteWithCompletableFutureCallBackThenRun()throws ExecutionException, InterruptedException {
        System.out.println("===JobExecuteWithCompletableFutureCallBackThenRun===");
        CompletableFuture<Void> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("grand " + Thread.currentThread().getName());
            return "piano";
        }).thenRun(() -> {
            System.out.println(Thread.currentThread().getName());
//            System.out.println(s.toUpperCase());//결과값 참고 불가
        });
        stringCompletableFuture.get();
    }

    private static void JobExecuteWithCompletableFutureCallBackThenAccept() throws ExecutionException, InterruptedException {
        System.out.println("===JobExecuteWithCompletableFutureCallBackThenAccept===");
        CompletableFuture<Void> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("grand " + Thread.currentThread().getName());
            return "piano";
        }).thenAccept((s) -> {//consumer
            System.out.println(Thread.currentThread().getName());
            System.out.println(s.toUpperCase());
        });
        stringCompletableFuture.get();

    }

    private static void JobExecuteWithCompletableFutureCallBackThenApply() throws ExecutionException, InterruptedException {
        System.out.println("===JobExecuteWithCompletableFutureSupplyAsyncThenApply===");
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("grand " + Thread.currentThread().getName());
            return "piano";
        }).thenApply((s) -> {
            System.out.println(Thread.currentThread().getName());
            return s.toUpperCase();
        });
        System.out.println(stringCompletableFuture.get());
    }

    private static void JobExecuteWithCompletableFutureSupplyAsync() throws ExecutionException, InterruptedException {
        System.out.println("===JobExecuteWithCompletableFutureSupplyAsync===");
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("grand " + Thread.currentThread().getName());
            return "piano";
        });
        System.out.println(stringCompletableFuture.get());


    }

    private static void JobExecuteWithCompletableFutureAsync() throws ExecutionException, InterruptedException {
        System.out.println("===JobExecuteWithCompletableFutureAsync===");
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() ->
                System.out.println("baby " + Thread.currentThread().getName()));
        voidCompletableFuture.get();
    }

    private static void JobExecuteWithCompletableFuture() throws InterruptedException, ExecutionException {
        System.out.println("===JobExecuteWithCompletableFuture===");
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        completableFuture.complete("my");
        System.out.println(completableFuture.get());
    }
}



