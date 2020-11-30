package test;

public class SaikoroGames {

  public static void main(String[] args) {

    // 各プレイヤーの合計値を代入
    int hokan[] = new int[3];
    
    // プレイヤー人数を決める
    int player = 3;
    int sum = 0;
    int dice = 0;
    
    int max = Integer.MIN_VALUE;
    // 人数分ループする
    for (int j = 0; j < player; j++) {
        System.out.printf("[%d] : ", j + 1);
      sum = 0;
      for (int i = 1; i <= player; i++) {
        dice = (int)(Math.random()*6)+1;
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
    for (int j = 0; j < player; j++) {
      if (hokan[j] == max) {
          System.out.println();
        System.out.printf("勝者は[%d]、" , j + 1);
        System.out.print("合計値は" + hokan[j]);
      }
    }
  }
}
