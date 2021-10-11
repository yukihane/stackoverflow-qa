package sample;

public class Kadai5_7 {

    public static void main(String[] args) {
        //配列データの宣言・初期化
        int[] arrays1 = { 96, 45, 31, 29, 84, 77 };
        //並び替え前の配列内を表示
        display(arrays1, false);
        //昇順で並び替えを実施
        arraysSort(arrays1, true);
        //並び替え後の配列内を表示
        display(arrays1, true);
        //降順で並び替えを実施
        arraysSort(arrays1, false);
        //並び替え後の配列内を表示
        display(arrays1, true);
    }

    public static void arraysSort(int[] array, boolean orderType) {
        if (orderType == true) {
            for (int i = 0; i < array.length; i++) {
                for (int j = i; j < array.length; j++) {
                    if (array[i] > array[j]) {
                        change(array, i, j);
                    }
                }
            }
        } else {
            for (int i = 0; i < array.length; i++) {
                for (int j = i; j < array.length; j++) {
                    if (array[i] < array[j]) {
                        change(array, i, j);
                    }
                }
            }
        }
    }

    public static void display(int[] array, boolean isSorted) {
        if (isSorted == true) {
            System.out.println("****並び替え後****");
        } else {
            System.out.println("****並び替え前****");
        }

        // 配列の出力方法は並び替え前後で同じ
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println();
    }

    public static void change(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
