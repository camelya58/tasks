package class_methods;

import java.util.ArrayList;

/**
 * Class FacadePattern represents facade for creating PetCreator using LiteralPetCreator.
 *
 * @author Kamila Meshcheryakova
 * created by 30.06.2020
 */
@SuppressWarnings("unused")
public class FacadePattern {
    public static final PetCreator creator = new LiteralPetCreator();

    public static Pet randomPet() {
        return creator.randomPet();
    }

    public static Pet[] createArray(int size) {
        return creator.createArray(size);
    }
    public static ArrayList<Pet> arrayList(int size) {
        return creator.arrayList(size);
    }
}
class PetCount {
    public static void main(String[] args) {
        InstanceofRecord.countPets(FacadePattern.creator);
    }
    // tha same result as in InstanceofRecord class
} /* Output:
Rat Manx Cymric Mutt Pug Cymric Pug Manx Cymric Rat EgyptianMau Hamster EgyptianMau
Mutt Mutt Cymric Mouse Pug Mouse Cymric
{EgyptianMau=2, Pug=3, Rat=2, Cymric=5, Mouse=2, Cat=9, Manx=7, Rodent=5, Mutt=3, Dog=6, Hamster=1}
*/
