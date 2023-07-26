package com.github.yukihane.so;

import java.util.concurrent.CompletableFuture;

public class App {
    private final Provider kanaProvider = new Provider();

    public CompletableFuture convert(String kana) {
        String japanized = "text";
        if (japanized.isEmpty()) {
            return CompletableFuture.completedFuture(kana);
        } else {
            return CompletableFuture.supplyAsync(() -> kanaProvider.parse(japanized)).thenApply(this::parse).exceptionally(e -> {
                System.out.println("API returned unexpected result:" + e);
                return "";
            }).thenApply(text -> text.isEmpty() ? (japanized.isEmpty() ? kana : japanized) : text);
        }
    }

    public String parse(String value) {
        String result = this.kanaProvider.parse(value);
        return result;
    }

}
