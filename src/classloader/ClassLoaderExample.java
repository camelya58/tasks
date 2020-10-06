package classloader;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

/**
 * Class ClassLoaderExample demonstrates the example of using classloader and reflection methods.
 *
 * @author Kamila Meshcheryakova
 * created by 06.10.2020
 */
public class ClassLoaderExample {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals(ClassLoaderExample.class.getProtectionDomain().getCodeSource().getLocation().getPath() + ClassLoaderExample.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        Set<Animal> set = new HashSet<>();
        String sep = System.getProperty("file.separator");
        String packagePath =  (pathToAnimals.endsWith(sep))? pathToAnimals : pathToAnimals.concat(sep);
        try {
            File file = new File(URLDecoder.decode(pathToAnimals, StandardCharsets.UTF_8));
            if (file.length() == 0) {
                return set;
            }
            AnimalLoader loader = new AnimalLoader();
            File[] files = file.listFiles();
            if (files == null) return set;
            for (File f : files) {
                if (!f.getName().endsWith(".class")) continue;
                // 1
                Class<?> clazz = loader.findClass(packagePath.concat(f.getName())); // or f.getAbsolutePath()
                // 2 or if you know the package name
//                String packageName = "classloader/data/".replace(sep, ".");
//                Class<?> clazz = Class.forName(packageName + f.getName().substring(0, f.getName().indexOf(".")));
                if (Animal.class.isAssignableFrom(clazz)) {
                    Constructor<?>[] constructors = clazz.getConstructors();
                    for (Constructor<?> constructor : constructors) {
                        if (constructor.getParameterCount() == 0 && constructor.getModifiers() == Modifier.PUBLIC) {
                            set.add((Animal) constructor.newInstance());
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return set;
    }

    static class AnimalLoader extends ClassLoader {

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            try {
                Path path = Paths.get(name);
                byte[] bytes = Files.readAllBytes(path);
                return defineClass(null, bytes, 0, bytes.length);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return super.findClass(name);
        }
    }
}
