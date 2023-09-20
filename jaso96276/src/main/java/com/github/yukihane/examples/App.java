package com.github.yukihane.examples;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Spliterators;
import java.util.stream.StreamSupport;

import static java.util.Spliterator.ORDERED;

public class App {

    private static int[] inputData;

    public void execute() {
        var scanner = new Scanner(System.in);
        var spliterator = Spliterators.spliteratorUnknownSize(scanner, ORDERED);
        var stream = StreamSupport.stream(spliterator, false);
        // 入力が終わったら(=終端操作として)配列オブジェクトを生成
        inputData = stream.mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(inputData)); // 初期値は null

        new App().execute(); // 入力操作

        System.out.println(Arrays.toString(inputData)); // 入力値
    }
}
