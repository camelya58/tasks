package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Class ProxySample demonstrates proxy for SomeInterfaceWithMethods interface.
 *
 * @author Kamila Meshcheryakova
 * created by 01.09.2020
 */
public class ProxySample {
    public static void main(String[] args) {
        SomeInterfaceWithMethods obj = getProxy();
        obj.stringMethodWithoutArgs();
        obj.voidMethodWithIntArg(1);
    }

    public static SomeInterfaceWithMethods getProxy() {
        //create the necessary classes to create a proxy
        SomeInterfaceWithMethods siwm = new SomeInterfaceWithMethodsImpl();
        ClassLoader classLoader = siwm.getClass().getClassLoader();
        Class<?>[] interfaces = siwm.getClass().getInterfaces();
        CustomInvocationHandler customInvocationHandler = new CustomInvocationHandler(siwm);
        return (SomeInterfaceWithMethods) Proxy.newProxyInstance(classLoader, interfaces, customInvocationHandler);
    }
}
 /* Output:
        stringMethodWithoutArgs in
        inside stringMethodWithoutArgs
        stringMethodWithoutArgs out
        voidMethodWithIntArg in
        inside voidMethodWithIntArg
        inside voidMethodWithoutArgs
        voidMethodWithIntArg out
 */

/**
 * Interface SomeInterfaceWithMethods contains multiple methods.
 */
interface SomeInterfaceWithMethods {
    void voidMethodWithoutArgs();

    String stringMethodWithoutArgs();

    void voidMethodWithIntArg(int i);
}

/**
 * Class SomeInterfaceWithMethodsImpl represents the realization of SomeInterfaceWithMethods interface.
 */
class SomeInterfaceWithMethodsImpl implements SomeInterfaceWithMethods {
    public void voidMethodWithoutArgs() {
        System.out.println("inside voidMethodWithoutArgs");
    }

    public String stringMethodWithoutArgs() {
        System.out.println("inside stringMethodWithoutArgs");
        return null;
    }

    public void voidMethodWithIntArg(int i) {
        System.out.println("inside voidMethodWithIntArg");
        voidMethodWithoutArgs();
    }
}

/**
 * Class CustomInvocationHandler represents the realization of InvocationHandler interface.
 * To create proxy we need to implements InvocationHandler interface and override a single method invoke(..).
 */
class CustomInvocationHandler implements InvocationHandler {

    private final SomeInterfaceWithMethods someInterfaceWithMethods;

    public CustomInvocationHandler(SomeInterfaceWithMethods someInterfaceWithMethods) {
        this.someInterfaceWithMethods = someInterfaceWithMethods;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println(method.getName() + " in");
        method.invoke(someInterfaceWithMethods, objects);
        System.out.println(method.getName() + " out");
        return "";
    }
}