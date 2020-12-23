package paterns.creational.prototype;

/**
 * Class PrototypePattern demonstrates the work of prototype pattern, which
 * allows to copy objects of any complexity without binding to their specific classes.
 *
 * @author Kamila Meshcheryakova
 * created 21.09.2020
 */
public class PrototypePattern {
    public static void main(String[] args) {
        Human human = new Human("Kirill", 20, Country.USA, new String[]{"dog", "cat", "hamster"});
        Human prototype = human.copy();
        String[] pets = prototype.getPets();
        pets[0] = "horse";

        System.out.println(human);
        System.out.println(prototype);

    }
}
/* Output:
Human{name='Kirill', age=20, country=USA, pets=[dog, cat, hamster]}
Human{name='Kirill', age=20, country=USA, pets=[horse, cat, hamster]}
 */
