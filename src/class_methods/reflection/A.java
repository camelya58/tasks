package class_methods.reflection;

/**
 * Interface A and another supporting classes.
 *
 * @author Kamila Meshcheryakova
 * created by 02.07.2020
 */
public interface A {
    void f();
}
class B implements A {

    @Override
    public void f() {
    }
    public void g() {
    }
}
class InterfaceViolation {
    public static void main(String[] args) {
        A a = new B();
        a.f();
        // a.g(); // Compile error
        System.out.println(a.getClass().getName());
        if(a instanceof B) {
            B b = (B) a; // now you can invoke the method of B class
            b.g();
        }
    }
}
class C implements A {
    private int i = 5;
    private String k = "It's ok";
    @Override
    public void f() {
        System.out.println("public C.f()");
    }
    public void g() {
        System.out.println("public C.g()");
    }
    void u() {
        System.out.println("package C.u()");
    }
    protected void v() {
        System.out.println("protected C.v()");
    }
    private void w() {
        System.out.println("private C.w()");
    }
    public String toString() {
        return "i = " + i + ", k = " + k;
    }
}
class HiddenC {
    public static A makeA() {
        return new C();
    }
}

