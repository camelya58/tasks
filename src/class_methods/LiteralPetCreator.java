package class_methods;

import java.util.List;

/**
 * Class LiteralPetCreator represents realization of abstract class PetCreator with all types of pets.
 *
 * @author Kamila Meshcheryakova
 * created by 30.06.2020
 */
public class LiteralPetCreator extends PetCreator {
    public static final List<Class<? extends  Pet>> allTypes =
            List.of(Pet.class, Dog.class, Cat.class, Rodent.class, Mutt.class,
                    Pug.class, EgyptianMau.class, Manx.class, Cymric.class,
                    Rat.class, Mouse.class, Hamster.class);
    // create random list of pets types
    private static final List<Class<? extends Pet>> types =
            allTypes.subList(allTypes.indexOf(Mutt.class), allTypes.size());
    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }

    public static void main(String[] args) {
        System.out.println(types);
    }
} /* Output:
[class class_methods.Mutt, class class_methods.Pug, class class_methods.EgyptianMau,
class class_methods.Manx, class class_methods.Cymric, class class_methods.Rat,
class class_methods.Mouse, class class_methods.Hamster]
*/
