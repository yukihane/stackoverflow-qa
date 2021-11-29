import java.util.Arrays;

//サブクラス
public class SubClass extends SuperClass {
    public SubClass(int[] array) {
        super(array);
    }

    @Override
    protected String calculation() {
        return String.valueOf(this.sum());
    }

    protected int sum() {
        return Arrays.stream(〇〇()).sum();
    }
}