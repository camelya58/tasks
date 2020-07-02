package class_methods.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Class HiddenMethods represents the way to show all methods and fields of the desired class include private
 * using such methods as getDeclaredMethods(), getDeclaredFields(),
 * getDeclaredMethod(String name), getDeclaredField(String name),
 *
 *
 * @author Kamila Meshcheryakova
 * created by 02.07.2020
 */
public class HiddenMethods {
    public static void main(String[] args) throws Exception {
        A a = HiddenC.makeA();
        a.f();
        System.out.println(a.getClass().getName());
        if(a instanceof C) {
            C c = (C) a;
            c.g();
            //c.w(); due to the fact that this method is private you can't invoke it
        }
        // invoke private method w()
        callHiddenMethod(a, "w");

        // get private filed int i
        Field number = getHiddenField(a, "i");
        // get the value of int i
        System.out.println("i = " + number.getInt(a));
        // change the value of int i to another value
        number.setInt(a, 10);
        // get all fields of class
        System.out.println(a);

    }
    private static void callHiddenMethod(Object a, String methodName) throws Exception {
        // allows to get all methods of class
        Method[] methods = a.getClass().getDeclaredMethods();
        for(Method method: methods)
            System.out.println(method);
        // allows to get the method of class by name
        Method method = a.getClass().getDeclaredMethod(methodName);
        // allows to get access to every method include private
        method.setAccessible(true);
        method.invoke(a);
    }
    private static Field getHiddenField(Object a, String i) throws Exception{
        // allows to get all fields of class
        Field[] fields = a.getClass().getDeclaredFields();
        for(Field field: fields)
            System.out.println(field);
        // allows to get the field of class by name
        Field field = a.getClass().getDeclaredField(i);
        // allows to get access to every field include private
        field.setAccessible(true);
        System.out.println(field);
        return field;
    }
} /* Output:
public C.f()
class_methods.reflection.C
public C.g()
public java.lang.String class_methods.reflection.C.toString()
public void class_methods.reflection.C.f()
public void class_methods.reflection.C.g()
protected void class_methods.reflection.C.v()
private void class_methods.reflection.C.w()
void class_methods.reflection.C.u()
private C.w()
private int class_methods.reflection.C.i
private java.lang.String class_methods.reflection.C.k
private int class_methods.reflection.C.i
i = 5
i = 10, k = It's ok
*/
