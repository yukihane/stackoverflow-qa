package rensyu;

import java.util.Date;
import java.util.*;

public class Register {
    static ArrayList<Kaiin> kaiinAll = new ArrayList<Kaiin>();

    public static void main(String[] args) {
        Register r = new Register();
        Scanner scan = new Scanner(System.in);
        System.out.println("何人登録しますか？");
        int i = scan.nextInt();
        int id = 0;
        String name = null;
        for (int j = 0; j < i; j++) {
            System.out.println("会員IDを入力してください");
            id = scan.nextInt();
            System.out.println("名前を入力してください");
            name = scan.next();
            kaiinAll.add(r.kaiinAdd(id, name));
            Kaiin lastElement = kaiinAll.get(kaiinAll.size() - 1);
            System.out.println(lastElement);
            
        }

    }

    private Kaiin kaiinAdd(int id, String name) {
        Kaiin k = new Kaiin();
        k.setId(id);
        k.setName(name);
        Date d = new Date();
        k.setAddDate(d);
        return k;

    }

}
