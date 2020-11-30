package test;

import java.util.ArrayList;
import java.util.List;

public class SaikoroGames {

    public static void main(String[] args) {

        // 各プレイヤーの合計値を代入
        int hokan[] = new int[3];

        // プレイヤー人数を決める
        int player = 3;
        int dice = 0;

        int max = Integer.MIN_VALUE;
        // 人数分ループする
        for (int j = 0; j < player; j++) {
            System.out.printf("[%d] : ", j + 1);
            int sum = 0;
            for (int i = 1; i <= player; i++) {
                dice = (int) (Math.random() * 6) + 1;
                System.out.print(dice + " ");
                sum += dice;

            }
            System.out.println();
            System.out.print("合計値 :" + sum);
            max = Math.max(max, sum);
            hokan[j] = sum;
            System.out.println();
            System.out.println();
        }
        // 勝者判定
        // 最大値(max)を獲得したプレーヤをピックアップ
        List<Integer> winners = new ArrayList<>();
        for (int j = 0; j < player; j++) {
            if (hokan[j] == max) {
                winners.add(j);
            }
        }
        // maxを獲得したプレーヤとmax値を出力
        System.out.println();
        System.out.printf("勝者は");
        for (int winner : winners) {
            System.out.printf("[%d]", winner + 1);
        }
        // maxを獲得したプレーヤが2人以上なら引き分け
        if (winners.size() >= 2) {
            System.out.print("(引き分け)");
        }
        System.out.print("、合計値は" + max);
    }
}
