package java8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class CompletableFutureTest3 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Supplier<Integer> initValueSupplier = () -> 100;
        Function<Integer, Integer> multiply = value -> value * 2;
        Consumer<Integer> valueConsumer = value -> System.out.println(value);

        CompletableFuture<Void> future = CompletableFuture.supplyAsync(initValueSupplier)
                .thenApplyAsync(multiply)
                .thenAcceptAsync(valueConsumer);
    }

}