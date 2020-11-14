package annotations.creation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Target;
import java.util.Arrays;

/**
 * Class AnnotationExample demonstrates annotation creation.
 * We use @interface before the name of annotation class.
 * And use 2 another annotations: @Retention - to set the type of loading(RUNTIME, SOURCE, CLASS)
 * and @Target - to set the level of annotation (TYPE means - class, interface).
 *
 * .@Retention(value = RetentionPolicy.RUNTIME)
 * .@Target(value = ElementType.TYPE)
 * public @interface Changelog {
 *
 *     Revision[] value();
 * }
 *
 * SOURCE - for compiler:
 * - @Native;
 * - @SuppressWarnings;
 * - @Override;
 * - @Generated;
 * - Lombok annotations;
 * - ect.
 *
 * CLASS - write in bytecode but not available at runtime:
 * - @NotNull;
 * - @Nullable;
 * - @Interned;
 * - ect.
 *
 * RUNTIME - while the code is running.
 *
 */
@Changelog({
        @Revision(
                revision = 4089,
                date = @Date(year = 2011, month = 5, day = 30, hour = 18, minute = 35, second = 18),
                comment = "Новый файл добавлен"),
        @Revision(
                revision = 6018,
                date = @Date(year = 2013, month = 1, day = 1, hour = 0, minute = 0, second = 1),
                authors = {@Author(value = "Сергей", position = Position.MIDDLE)},
                comment = "Фикс багов"),
        @Revision(
                revision = 10135,
                date = @Date(year = 2014, month = 12, day = 31, hour = 23, minute = 59, second = 59),
                authors = {@Author(value = "Диана", position = Position.JUNIOR),
                        @Author("Игорь"),
                        @Author(value = "Виктор", position = Position.SENIOR)})
})
public class AnnotationCreation {

    public static void main(String[] args) {
        // the method allows to check does some class have a concrete annotation
        if (AnnotationCreation.class.isAnnotationPresent(Changelog.class)) {
            // the method allows to get the object of concrete annotation
            System.out.println(AnnotationCreation.class.getAnnotation(Changelog.class).toString());
        }
        // method allows to get the array of all annotations
        Annotation[] array = Target.class.getAnnotations();
        System.out.println(Arrays.toString(array));
    }
}
