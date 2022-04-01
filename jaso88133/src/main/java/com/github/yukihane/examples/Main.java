package com.github.yukihane.examples;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        // 要素数が5の配列 nums を宣言して初期値を代入
        int[] nums = { 1, 2, 3, 4, 5 };

        // 3回繰り返す
        for (int i = 0; i < 3; i++) {
            // num を宣言して、 配列 nums の要素(nums[0], nums[1], ..., nums[4])のうちのひとつを代入
            int num = nums[random.nextInt(5)];
            // num を出力する
            System.out.println(num);
        }

    }
}
