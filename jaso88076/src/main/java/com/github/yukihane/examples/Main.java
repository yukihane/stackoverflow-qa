package com.github.yukihane.examples;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("年齢を打ってください:");
                int age = sc.nextInt();

                System.out.println("あなたは " + age + "歳です。!");
                break;
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("あなたの年齢を打ってください。");
            }
        }
    }
}
