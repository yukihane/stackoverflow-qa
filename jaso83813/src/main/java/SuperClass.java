import java.util.ArrayList;
import java.util.List;

//スーパークラス
abstract class SuperClass {
    private List<Integer> list = new ArrayList<>();

    public SuperClass(int[] array) {
        for (int value : array) {
            list.add(value);
        }
    }

    public List<Integer> getList() {
        return list;
    }

    protected int[] 〇〇() {
        int[] array = new int[list.size()];
        Object[] values = list.toArray();
        for (int i = 0; i < values.length; i++) {
            array[i] = (Integer) values[i];
        }
        return array;
    }

    public String execute() {
        String value = calculation();
        return "結果：" + value;
    }

    protected abstract String calculation();

}