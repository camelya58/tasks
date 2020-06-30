package class_methods;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Class IsInstance represents the way to count different kind of objects of classes extending Pets
 *  without using the record "instanceOf".
 *
 * @author Kamila Meshcheryakova
 * created by 30.06.2020
 */
public class IsInstance {
    static class PetCounter extends LinkedHashMap<Class<? extends Pet>, Integer> {
        public PetCounter() {
            super(MapData.map(LiteralPetCreator.allTypes,0));
        }
        public void count(Pet pet) {
            // Class.isInstance help to avoid the chain of instanceof
          for(Map.Entry<Class<? extends Pet>, Integer> pair: entrySet())
              if(pair.getKey().isInstance(pet))
                  put(pair.getKey(), pair.getValue() + 1);
        }
        public String toString() {
            StringBuilder  result = new StringBuilder("{");
            for(Map.Entry<Class<? extends Pet>, Integer> pair: entrySet()) {
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

    public static void main(String[] args) {
        PetCounter petCount = new PetCounter();
        for (Pet pet: FacadePattern.createArray(20)) {
            System.out.print(pet.getClass().getSimpleName() + " ");
            petCount.count(pet);
        }
        System.out.println();
        System.out.println(petCount);
    }
} /* Output:
Rat Manx Cymric Mutt Pug Cymric Pug Manx Cymric Rat EgyptianMau Hamster
EgyptianMau Mutt Mutt Cymric Mouse Pug Mouse Cymric
{Pet=20, Dog=6, Cat=9, Rodent=5, Mutt=3, Pug=3, EgyptianMau=2, Manx=7, Cymric=5, Rat=2, Mouse=2, Hamster=1}
*/
