
public class Main {
    public static void main(String[] args) {
        int[] num = { 1,2,3,4,5,6 };
        SuperClass myArray = new SubClass(num);
        String result = myArray.execute();
        System.out.println(result);
    }
}
