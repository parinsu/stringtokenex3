
import java.io.*;

public class C extends A {

    String name1;
    String name2;

    B() {
        this.name = NULL;
    }

    B(String name) {
        this.name = name;
    }

    public static void main(String args[]) {
        A a1 = new A();
        A a2 = new A();
        B b1 = new B();
        C c1 = new C();
    }
}
