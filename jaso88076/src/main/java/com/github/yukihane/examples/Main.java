package com.github.yukihane.examples;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("年齢を打ってください:");
                // 文字列として取得するので数字でなくても例外は発生しない
                String text = sc.nextLine();
                // ここで文字列を数値に変換
                // 数値に変換できなかった場合の例外は NumberFormatException
                // https://docs.oracle.com/javase/jp/17/docs/api/java.base/java/lang/Integer.html#valueOf(java.lang.String)
                int age = Integer.valueOf(text);

                System.out.println("あなたは " + age + "歳です。!");
                break;
            } catch (NumberFormatException e) {
                // 上の処理でスキャナから入力情報は取り除かれているので
                // ここで sc.nextLine(); を呼び出す必要はない
                System.out.println("あなたの年齢を打ってください。");
            }
        }
    }
}
