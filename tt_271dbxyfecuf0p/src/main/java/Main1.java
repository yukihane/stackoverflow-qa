public class Main1 {

    public static void main(final String args[]) {
        final String str1 = "すとりんぐ１";
        final String str2 = "すとりんぐ１";
        final String str3 = new String("すとりんぐ１");
        final String str4 = str3.intern();

        assert str1 == str2;
        assert str1 != str3;
        assert str1 == str4;
    }
}
