package com.github.yukihane;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

public class App {

    public static void main(final String[] args) {
        final List<Integer> nums = new Random().ints(10, 1, 4).boxed().collect(Collectors.toList());
        System.out.println(nums); // [1, 2, 3, 3, 1, 2, 2, 1, 2, 3]

        final Map<Integer, List<Integer>> group = nums.stream().collect(Collectors.groupingBy(Function.identity()));
        System.out.println(group.values()); // [[1, 1, 1], [2, 2, 2, 2], [3, 3, 3]]
    }
}
