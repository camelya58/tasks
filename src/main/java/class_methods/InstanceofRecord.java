package class_methods;

import java.util.HashMap;

/**
 * Class InstanceofRecord represents the way to count different kind of objects of classes extending Pets
 * using the record "instanceof".
 *
 * @author Kamila Meshcheryakova
 * created by 30.06.2020
 */
public class InstanceofRecord {
    static class PetCounter extends HashMap<String, Integer> {
        public void count(String type) {
            Integer quantity = get(type);
            if (quantity == null)
                put(type, 1);
            else
                put(type, quantity + 1 );
        }
    }
    public static void countPets(PetCreator creator) {
        PetCounter counter = new PetCounter();
        for (Pet pet : creator.arrayList(20)) {
            // count objects of classes extends Pet
            System.out.print(pet.getClass().getSimpleName() + " ");
            if (pet instanceof Dog) {
                counter.count("Dog");
            }
            if (pet instanceof Mutt) { // it's a kind of dog
                counter.count("Mutt");
            }
            if (pet instanceof Pug) { // it's a kind of dog
                counter.count("Pug");
            }
            if (pet instanceof Cat) {
                counter.count("Cat");
            }
            if (pet instanceof EgyptianMau) { // it's a kind of cat
                counter.count("EgyptianMau");
            }
            if (pet instanceof Manx) { // it's a kind of cat
                counter.count("Manx");
            }
            if (pet instanceof Cymric) { // it's a kind of manx
                counter.count("Cymric");
            }
            if (pet instanceof Rodent) {
                counter.count("Rodent");
            }
            if (pet instanceof Rat) { // it's a kind of rodent
                counter.count("Rat");
            }
            if (pet instanceof Mouse) { // it's a kind of rodent
                counter.count("Mouse");
            }
            if (pet instanceof Hamster) { // it's a kind of rodent
                counter.count("Hamster");
            }
        }
            System.out.println();
            System.out.println(counter);
    }

    public static void main(String[] args) {
        countPets(new ForNameCreator());
    }
} /* Output:
Rat Manx Cymric Mutt Pug Cymric Pug Manx Cymric Rat EgyptianMau Hamster EgyptianMau
Mutt Mutt Cymric Mouse Pug Mouse Cymric
{EgyptianMau=2, Pug=3, Rat=2, Cymric=5, Mouse=2, Cat=9, Manx=7, Rodent=5, Mutt=3, Dog=6, Hamster=1}
*/
