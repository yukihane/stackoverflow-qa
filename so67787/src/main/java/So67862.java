import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Consumer;
import java.util.function.Function;

public class So67862 {
    public static void main(final String[] args) throws InterruptedException, ExecutionException {

        final ExecutorService es = ForkJoinPool.commonPool();
        //        final ExecutorService es = Executors.newFixedThreadPool(1);
        final CompletableFuture<String> future1 = CompletableFuture.supplyAsync(
            () -> {
                // 時間のかかる処理
                try {
                    Thread.sleep(1000);
                } catch (final InterruptedException e) {
                    e.printStackTrace();
                }
                return "java1";
                }
            );

        // thenApplyの場合
        future1
            .thenApply(
                new Function<String, String>() {
                    @Override
                    public String apply(final String res) {
                        return res; // resには、future1のreturnで定義した「java1」が入っている
                    }
                })
            .thenApply(
                res -> {
                    return res; // resには1回目のthenApplyの戻り値の「java1」が入っている
                })
            .thenAccept(
                new Consumer<String>() {
                    @Override
                    public void accept(final String res) {
                        System.out.println(res); // resには2回目のthenApplyの戻り値の「java1」が入っており、コンソールに出力される
                    }
                });
    }
}
