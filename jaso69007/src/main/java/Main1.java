public class Main1 {
    public static void main(String[] args) {
        Hero a = new Hero();

        a.name = "ピカチュウ";
        a.hp = 100;

        System.out.println("勇者" + a.name + "を生み出した！");

        a.sit(5);
    }
}
