package class_methods;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Class PetCreator is supporting class for creating different kinds of pets.
 *
 * @author Kamila Meshcheryakova
 * created by 30.06.2020
 */
public abstract class PetCreator {
    private final Random rand = new Random(47);

    // collection List with different instances of classes extending Pets
    public abstract List<Class<? extends Pet>> types();

    // creation of single random object of class Pet
    public Pet randomPet() {
        int n = rand.nextInt(types().size());
        try {
            return types().get(n).getDeclaredConstructor().newInstance();
        } catch (NoSuchMethodException | SecurityException | InstantiationException |
                IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
    public Pet[] createArray(int size) {
        Pet[] result = new Pet[size];
        for (int i = 0; i < size; i++)
            result[i] = randomPet();
        return result;
    }
    public ArrayList<Pet> arrayList(int size) {
        ArrayList<Pet> result = new ArrayList<>();
        Collections.addAll(result, createArray(size));
        return result;
    }
}
