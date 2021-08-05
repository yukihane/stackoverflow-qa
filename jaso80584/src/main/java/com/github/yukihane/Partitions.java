package com.github.yukihane;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

public class Partitions {
    public static void main(String[] args) {
        partition(7, 7, 0);
    }

    public static void partition(int i, int n, int r) {
        if (n == 0) {
            write(r);
            return;
        }

        if (i < n) {
            for (int j = i; j >= 1; j--) {
                partition(j, n - j, push(r, j));
            }
        } else {
            for (int j = n; j >= 1; j--) {
                partition(j, n - j, push(r, j));
            }
        }
    }

    static void write(int r) {
        String numbers = stream(r).map(String::valueOf).collect(Collectors.joining(","));
        System.out.println("{" + numbers + "}");
    }

    static int push(int r, int j) {
        return (r << 3) | j;
    }

    static Stream<Integer> stream(int r) {
        Builder<Integer> ret = Stream.builder();
        while (r > 0) {
            int v = r & 0x7;
            ret.add(v);
            r = r >>> 3;
        }
        return ret.build();
    }
}
