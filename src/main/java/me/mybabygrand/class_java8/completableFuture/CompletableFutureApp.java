package me.mybabygrand.class_java8.completableFuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class CompletableFutureApp {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        JobExecuteWithCompletableFuture();
//        JobExecuteWithCompletableFutureAsync();
//        JobExecuteWithCompletableFutureSupplyAsync();
//        JobExecuteWithCompletableFutureCallBackThenApply();
//        JobExecuteWithCompletableFutureCallBackThenAccept();
//        JobExecuteWithCompletableFutureCallBackThenRun();
//        JobExecuteWithCompletableFutureCallBackThenCompose();
//        JobExecuteWithCompletableFutureCallBackThenCombine();
//        JobExecuteWithCompletableFutureCallBackAllOf();
//        JobExecuteWithCompletableFutureCallBackAnyOf();
//        JobExecuteWithCompletableFutureCallBackExceptionally();
        JobExecuteWithCompletableFutureCallBackHandle();
    }

    private static void JobExecuteWithCompletableFutureCallBackHandle() throws ExecutionException, InterruptedException {
        System.out.println("===JobExecuteWithCompletableFutureCallBackHandle===");
        boolean throwError = false;
        CompletableFuture<String> handle = CompletableFuture.supplyAsync(() -> {
            if (throwError) {
                throw new IllegalArgumentException();
            }
            System.out.println("my " + Thread.currentThread().getName());
            return "my";
        }).handle((result, ex) -> {
            if(ex!=null){
                System.out.println(ex);
                return "error!";
            }
            return result;
        });
        System.out.println(handle.get());
    }

    private static void JobExecuteWithCompletableFutureCallBackExceptionally() throws ExecutionException, InterruptedException {
        System.out.println("===JobExecuteWithCompletableFutureCallBackExceptionally===");
        boolean throwError = true;
        CompletableFuture<String> exceptionally = CompletableFuture.supplyAsync(() -> {
            if (throwError) {
                throw new IllegalArgumentException();
            }
            System.out.println("my " + Thread.currentThread().getName());
            return "my";
        }).exceptionally(ex -> {
            System.out.println(ex);
            return "error!";
        });
        System.out.println(exceptionally.get());

    }

    private static void JobExecuteWithCompletableFutureCallBackAnyOf() throws ExecutionException, InterruptedException {
        System.out.println("===JobExecuteWithCompletableFutureCallBackAnyOf===");
        CompletableFuture<String> my = getSupplyAsync("my");
        CompletableFuture<String> baby = getSupplyAsync("baby");
        CompletableFuture<String> grand = getSupplyAsync("grand");
        CompletableFuture<Void> future = CompletableFuture.anyOf(my, baby, grand).thenAccept((s) -> {
            System.out.println(s);
        });
        System.out.println(future.get());

    }

    private static void JobExecuteWithCompletableFutureCallBackAllOf() throws ExecutionException, InterruptedException {
        System.out.println("===JobExecuteWithCompletableFutureCallBackAllOf===");
        CompletableFuture<String> my = getSupplyAsync("my");
        CompletableFuture<String> baby = getSupplyAsync("baby");

        List<CompletableFuture> futures = Arrays.asList(my, baby);
        CompletableFuture[] futuresArray = futures.toArray(futures.toArray(new CompletableFuture[futures.size()]));

        CompletableFuture<List<Object>> results = CompletableFuture.allOf(futuresArray).
                thenApply(v -> futures.stream()
                        .map(CompletableFuture::join).collect(Collectors.toList()));
        results.get().forEach(System.out::println);
    }

    private static void JobExecuteWithCompletableFutureCallBackThenCombine() throws ExecutionException, InterruptedException {
        System.out.println("===JobExecuteWithCompletableFutureCallBackThenCombine===");
        CompletableFuture<String> my = getSupplyAsync("my");
        CompletableFuture<String> baby = getSupplyAsync("baby");
        CompletableFuture<String> stringCompletableFuture = my.thenCombine(baby, (h, w) -> h + " / " + w);
        System.out.println(stringCompletableFuture.get());

    }

    private static void JobExecuteWithCompletableFutureCallBackThenCompose() throws ExecutionException, InterruptedException {
        System.out.println("===JobExecuteWithCompletableFutureCallBackThenCompose===");
        CompletableFuture<String> my = getSupplyAsync("my");
        CompletableFuture<String> stringCompletableFuture = my.thenCompose(CompletableFutureApp::getSupplyAsync);
        System.out.println(stringCompletableFuture.get());

    }

    private static CompletableFuture<String> getSupplyAsync(String message) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println(message+ " " + Thread.currentThread().getName());
            return message;
        });
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




