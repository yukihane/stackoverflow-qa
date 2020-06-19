import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;

public class CompletableFutureSample {
    public static void main(final String[] args) {

        // 並列レベルは ForkJoinPool.getCommonPoolParallelism()
        final Executor es = ForkJoinPool.commonPool();
        // 並列レベル1, つまり直列実行
        // final Executor es = new ForkJoinPool(1);

        final long start = System.currentTimeMillis();

        final CompletableFuture<Integer> cf = CompletableFuture.supplyAsync(() -> 1 * 100 * 35 * 42 * 75, es);
        final CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(() -> 2 * 100 * 35 * 42 * 75, es);

        cf.thenAcceptBoth(cf2, (c1, c2) -> {
            System.out.println("cf :" + c1 + ", cf2 : " + c2);
            System.out.println("result : " + (c1 + c2));
        });

        final long end = System.currentTimeMillis();
        System.out.println((end - start) + "ms");
    }
}
