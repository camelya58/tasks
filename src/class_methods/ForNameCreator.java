package class_methods;

import java.util.ArrayList;
import java.util.List;

/**
 * Class ForNameCreator represents realization of abstract class PetCreator with 8 types of pets.
 *
 * @author Kamila Meshcheryakova
 * created by 30.06.2020
 */
public class ForNameCreator extends PetCreator {
    private static final List<Class<? extends  Pet>> types = new ArrayList<>();
    private static final String[] typeNames = {
            "class_methods.Mutt",
            "class_methods.Pug",
            "class_methods.EgyptianMau",
            "class_methods.Manx",
            "class_methods.Cymric",
            "class_methods.Rat",
            "class_methods.Mouse",
            "class_methods.Hamster"
    };
    @SuppressWarnings("unchecked")
    private static void loader() {
        try {
            for (String name: typeNames)
                types.add(
                        (Class<? extends Pet>)Class.forName(name));
        } catch(ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    static {loader();}
    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }
}
