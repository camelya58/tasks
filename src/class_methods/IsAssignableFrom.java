package class_methods;

import java.util.HashMap;
import java.util.Map;

/**
 * Class IsAssignableFrom the way to count different kind of objects of classes extending Pets
 * using check - isAssignableFrom().
 *
 * @author Kamila Meshcheryakova
 * created by 02.07.2020
 */
public class IsAssignableFrom extends HashMap<Class<?>, Integer> {
    private Class<?> baseType;
    public IsAssignableFrom(Class<?> baseType) {
        this.baseType = baseType;
    }

    public void count (Object obj) {
        Class<?> type = obj.getClass();
        // check whether an object belongs to a desired hierarchy
        if(!baseType.isAssignableFrom(type)) {
            throw new RuntimeException(obj + " wrong type: " + type + " must be inheritor of " + baseType);
        }
        countClass(type);
    }

    //  the method countClass() at the beginning count instances of real type class
    //  and then if it's possible invokes the method for superclass
    private void countClass(Class<?> type) {
        Integer quantity = get(type);
        put(type, quantity == null ? 1 : quantity + 1);
        Class<?> superClass = type.getSuperclass();
        if(superClass != null && baseType.isAssignableFrom(superClass))
            countClass(superClass);
    }

    public String toString() {
        StringBuilder  result = new StringBuilder("{");
        for(Map.Entry<Class<?>, Integer> pair: entrySet()) {
            result.append(pair.getKey().getSimpleName());
            result.append("=");
            result.append(pair.getValue());
            result.append(", ");
        }
        result.delete(result.length()-2, result.length());
        result.append("}");
        return result.toString();
    }
}

class PetCount2 {
    public static void main(String[] args) {
        IsAssignableFrom counter = new IsAssignableFrom(Pet.class);
        for(Pet pet: FacadePattern.createArray(20)) {
            System.out.print(pet.getClass().getSimpleName() + " ");
            counter.count(pet);
        }
        System.out.println();
        System.out.println(counter);
    }
} /* Output:
Rat Manx Cymric Mutt Pug Cymric Pug Manx Cymric Rat EgyptianMau Hamster
EgyptianMau Mutt Mutt Cymric Mouse Pug Mouse Cymric
{Rat=2, Hamster=1, Rodent=5, Mutt=3, Mouse=2, EgyptianMau=2, Pet=20, Pug=3, Dog=6, Manx=7, Cat=9, Cymric=5}
*/
