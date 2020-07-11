package com.github.yukihane.so;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        System.out.println("enter total number of strings");
        int x = sc.nextInt();
        String sarray[] = new String[x];
        System.out.println("enter your string");
        sc = new Scanner(System.in);
        for (int q = 0; q < x; q++) {
            sarray[q] = sc.nextLine();
        }

        for (int i = 0; i < x; i++) {
            System.out.println(sarray[i]);
        }
    }
}