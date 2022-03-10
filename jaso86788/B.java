package package_35;

public class B extends A {

    private void print() {
        System.out.println("B");
    }

    public void b() {
        print();
    }

    public static void main(String[] args) {
        B b = new B();
        b.a();
        b.b();
    }
}
