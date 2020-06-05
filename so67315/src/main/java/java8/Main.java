package java8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // TODO 自動生成されたメソッド・スタブ
        System.out.println(Thread.currentThread().getName() + ": main() started.");
        //Googleの株価
        CompletableFuture cf1 = CompletableFuture.supplyAsync(() -> downloadStockInfo("GOOG"))
                .thenApply(Main::extractClosePrices)
                .thenAccept(Main::printAveragePrice);
        //Amazonの株価
        CompletableFuture cf2 = CompletableFuture.supplyAsync(() -> downloadStockInfo("AMZN"))
                .thenApply(Main::extractClosePrices)
                .thenAccept(Main::printAveragePrice);
        //Appleの株価
        CompletableFuture cf3 = CompletableFuture.supplyAsync(() -> downloadStockInfo("AAPL"))
                .thenApply(Main::extractClosePrices)
                .thenAccept(Main::printAveragePrice);
        System.out.println(Thread.currentThread().getName() + ": main() running.");
        cf1.get();
        cf2.get();
        cf3.get();
        System.out.println(Thread.currentThread().getName() + ": main() end.");
    }

    /**
     * YahooファイナンスのURLから指定した銘柄の数年分の株価情報を取得する
     * @param ticker 銘柄のID
     * @return 株価情報テーブル
     */
    private static Stream<String> downloadStockInfo(final String ticker) {
        try {
            URL url = new URL("https://ichart.finance.yahoo.com/table.csv?s=" + ticker);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            System.out.println(Thread.currentThread().getName() + ": downloadStockInfo() executed. ticker " + ticker);
            return reader.lines();
        } catch(Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * 株価情報テーブルから終値を抽出する
     * @param stockInfo 株価情報テーブル
     * @return 株価情報テーブルから抽出した終値
     */
    private static Stream<BigDecimal> extractClosePrices(Stream<String> stockInfo) {
        Stream<String> closePricesStr = stockInfo.skip(1).map(x -> x.split(",")[4]);
        Stream<BigDecimal> closePrices = closePricesStr.map(BigDecimal::new);
        System.out.println(Thread.currentThread().getName() + ": getClosePrice() executed.");
        return closePrices;
    }

    /**
     * 終値の平均値を計算し出力する
     * @param closePrices 終値の数年分のリスト
     */
    private static void printAveragePrice(Stream<BigDecimal> closePrices){
        Double average = closePrices.mapToDouble(BigDecimal::doubleValue).average().getAsDouble();
        System.out.println(Thread.currentThread().getName() + ": printAveragePrice() executed. avg " + average + ".");
    }

}