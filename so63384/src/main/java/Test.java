import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.Data;

public class Test {
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        ArrayList<Test1> array1 = new ArrayList<Test1>();
        ArrayList<Test1> array2 = new ArrayList<Test1>();
        ArrayList<Test1> arrayEx = new ArrayList<Test1>();

        test1.setKey("1");
        test1.setHoge1("hoge1");
        test1.setHoge2(null);
        test1.setHoge3(null);
        array1.add(test1);
        test1 = new Test1();

        test1.setKey("1");
        test1.setHoge1(null);
        test1.setHoge2("hoge2");
        test1.setHoge3(null);
        array1.add(test1);
        test1 = new Test1();

        test1.setKey("1");
        test1.setHoge1(null);
        test1.setHoge2(null);
        test1.setHoge3("hoge3");
        array1.add(test1);
        test1 = new Test1();

        test1.setKey("2");
        test1.setHoge1(null);
        test1.setHoge2(null);
        test1.setHoge3("hoge3");
        array1.add(test1);
        test1 = new Test1();

        // key ごとにグルーピング
        Map<String, List<Test1>> group = array1.stream().collect(Collectors.groupingBy(Test1::getKey));

        for (List<Test1> list : group.values()) {
            // listの中身はすべて同じkeyでグルーピングされているので
            // 全てを順繰りに結合
            System.out.println("処理対象: " + list);
            Optional<Test1> merged = list.stream().reduce((t1, t2) -> {
//                // 手動で "結合"
//                String t1Hoge1 = t1.getHoge1();
//                if (t1Hoge1 != null) {
//                    t2.setHoge1(t1Hoge1);
//                }
//                String t1Hoge2 = t1.getHoge2();
//                if (t1Hoge2 != null) {
//                    t2.setHoge2(t1Hoge2);
//                }
//                String t1Hoge3 = t1.getHoge3();
//                if (t1Hoge3 != null) {
//                    t2.setHoge3(t1Hoge3);
//                }
//                return t2;
                // MapStructを用いて "結合"
                 Test1Mapper.INSTANCE.merge(t1, t2);
                 return t2;
            });

            System.out.println("処理結果: " + merged);
            // 結合結果を格納
            merged.ifPresent(arrayEx::add);
        }

        System.out.println("最終結果: " + arrayEx);
    }

}

@Data
class Test1 {
    private String key;
    private String hoge1;
    private String hoge2;
    private String hoge3;
}
