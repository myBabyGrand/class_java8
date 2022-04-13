package me.mybabygrand.class_java8.completableFuture;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class CallerAndFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("===JobExecuteWithCallable===");
        JobExecuteWithCallable();
        System.out.println("===JobExecuteWithCallableCancel===");
        JobExecuteWithCallableCancel();
        System.out.println("===JobExecuteWithCallableInvokeAll===");
        JobExecuteWithCallableInvokeAll();
        System.out.println("===JobExecuteWithCallableInvokeAny===");
        JobExecuteWithCallableInvokeAny();
    }

    private static void JobExecuteWithCallableInvokeAny() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Callable<String> my = () ->{
            Thread.sleep(3000L);
            return "my";
        };
        Callable<String> baby = () ->{
            Thread.sleep(4000L);
            return "baby";
        };
        Callable<String> grand = () ->{
            Thread.sleep(1000L);
            return "grand";
        };
        String s = executorService.invokeAny(Arrays.asList(my, baby, grand));

        System.out.println(s);

        executorService.shutdown();
    }

    private static void JobExecuteWithCallableInvokeAll() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Callable<String> my = () ->{
            Thread.sleep(3000L);
            return "my";
        };
        Callable<String> baby = () ->{
            Thread.sleep(4000L);
            return "baby";
        };
        Callable<String> grand = () ->{
            Thread.sleep(1000L);
            return "grand";
        };
        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(my, baby, grand));
        for (Future<String> future : futures) {
            System.out.println(future.get());
        }
        executorService.shutdown();
    }

    private static void JobExecuteWithCallableCancel() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable<String> hello = () ->{
            Thread.sleep(3000L);
            return "hello";
        };
        Future<String> submit = executorService.submit(hello);
        System.out.println("aaaaa");


        submit.cancel(false);
        System.out.println(submit.isDone());//무조건 true

        System.out.println("bbbbb");
        executorService.shutdown();
    }

    private static void JobExecuteWithCallable() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable<String> hello = () ->{
            Thread.sleep(3000L);
            return "hello";
        };
        Future<String> submit = executorService.submit(hello);
        System.out.println("aaaaa");
        //isDone으로 확인가능
        System.out.println(submit.isDone());

        submit.get(); //blocking call

        System.out.println(submit.isDone());
        System.out.println("bbbbb");
        executorService.shutdown();
    }
}
