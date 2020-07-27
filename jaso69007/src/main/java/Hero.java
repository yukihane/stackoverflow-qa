public class Hero {
    String name;
    int hp;
    int level = 10;

    public void sleep() {
        this.hp = 100;
        System.out.println(this.name + "は眠って回復した！");
    }

    public void sit(int sec) {
        this.hp += sec;
        System.out.println(this.name + "は" + sec + "秒座った");
    }
}
