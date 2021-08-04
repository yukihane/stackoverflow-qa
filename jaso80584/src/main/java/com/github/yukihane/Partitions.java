package com.github.yukihane;

public class Partitions {
    public static void main(String[] args) {
        partition(7, 7, "");
    }

    public static void partition(int i, int n, String r) {
        if (n == 0) {
            System.out.println("{" + r + "}");
            return;
        }

        /*
           for (int j = Math.min(i, n);j >= 1;j--) {
           partition(j, n - j, j + (r.isEmpty()?"":",")+r);
           }
        
         */

        if (i < n) {
            for (int j = i; j >= 1; j--) {
                partition(j, n - j, j + (r.isEmpty() ? "" : ",") + r);
            }
        } else {
            for (int j = n; j >= 1; j--) {
                partition(j, n - j, j + (r.isEmpty() ? "" : ",") + r);
            }
        }
    }
}