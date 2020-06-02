package java8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class CompletableFutureTest3 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Supplier<Integer> initValueSupplier = () -> 100;
        Function<Integer, Integer> multiply = value -> value * 2;
        Consumer<Integer> valueConsumer = value -> {
            try {
                Thread.sleep(1000);
                System.out.println(value);
            } catch (InterruptedException e) {
            }
        };

        // ExecutorService es = ForkJoinPool.commonPool();
        ExecutorService es = Executors.newFixedThreadPool(1);

        CompletableFuture<Void> future = CompletableFuture.supplyAsync(initValueSupplier, es)
            .thenApplyAsync(multiply, es)
            .thenAcceptAsync(valueConsumer, es);

    }
}
