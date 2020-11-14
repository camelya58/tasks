package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Class MethodSelector represents the way to create a proxy and to find definite methods of a proxy.
 *
 * @author Kamila Meshcheryakova
 * created by 02.07.2020
 */
public class MethodSelector implements InvocationHandler {
    private final Object proxied;
    public MethodSelector(Object proxied) {
        this.proxied = proxied;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("interesting"))
            System.out.println("Proxy detected the interesting method");
        return method.invoke(proxied, args);
    }
}
interface SomeMethods {
    void boring1();
    void boring2();
    void interesting(String arg);
    void boring3();
}
class Implementation implements SomeMethods {

    @Override
    public void boring1() {
        System.out.println("boring1");
    }

    @Override
    public void boring2() {
        System.out.println("boring2");
    }

    @Override
    public void interesting(String arg) {
        System.out.println("interesting " + arg);
    }

    @Override
    public void boring3() {
        System.out.println("boring3");
    }
}
class SelectingMethods {
    public static void main(String[] args) {
        // dynamic proxy is created by calling a static method Proxy.newProxyInstance()
        // which the class loader is passed,
        // the array of interfaces to be implemented by proxy,
        // a call handler - the realization of InvocationHandler interface

        SomeMethods proxy = (SomeMethods) Proxy.newProxyInstance(
                SomeMethods.class.getClassLoader(),
                new Class[]{SomeMethods.class},
                new MethodSelector(new Implementation()));
        proxy.boring1();
        proxy.boring2();
        proxy.interesting("bonobo");
        proxy.boring3();
    }
} /* Output:
boring1
boring2
Proxy detected the interesting method
interesting bonobo
boring3
*/
