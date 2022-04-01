package com.github.yukihane.examples;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        int[] nums = { 1, 2, 3, 4, 5 };
        int num = nums[random.nextInt(5)];

        for (int i = 0; i < 3; i++) {
            System.out.println(num);
        }

    }
}
