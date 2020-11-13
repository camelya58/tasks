package annotations.handle;

import java.util.Arrays;

/**
 * Class AnnotationHandle demonstrates the way to handle the annotation.
 */
public class AnnotationHandle {
    public static void main(String[] args) {
        System.out.println(printFullyQualifiedNames(AnnotationHandle.class));
        System.out.println(printFullyQualifiedNames(SomeTest.class));

        System.out.println(printValues(AnnotationHandle.class));
        System.out.println(printValues(SomeTest.class));
    }

    public static boolean printFullyQualifiedNames(Class<?> c) {

        if (c.isAnnotationPresent(PrepareMyTest.class)) {
            // invoke single method of annotation
            System.out.println(Arrays.toString((c.getAnnotation(PrepareMyTest.class)).fullyQualifiedNames()));
            return true;
        } else {
            return false;
        }
    }

    public static boolean printValues(Class<?> c) {
        if (c.isAnnotationPresent(PrepareMyTest.class)) {
            // invoke single method of annotation
            System.out.println(Arrays.toString((c.getAnnotation(PrepareMyTest.class)).value()));
            return true;
        } else {
            return false;
        }
    }
}
