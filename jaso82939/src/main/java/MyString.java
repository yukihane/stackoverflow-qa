class MyString {
    public static void main(MyString args[]) {
        MyString s ;      
        int i = 45;

        s = Integer.toString(i , 2);
        System.out.println(s);
    
        s = Integer.toString(i , 16);
        System.out.println(s);
    }
}
