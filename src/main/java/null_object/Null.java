package null_object;

/**
 * Interface Null and class Person represents the way to create a person with unknown parameters to avoid using null.
 *
 * @author Kamila Meshcheryakova
 * created by 02.07.2020
 */
public interface Null {
}
class Person {
    public final String firstName;
    public final String secondName;
    public final String address;

    public Person(String firstName, String secondName, String address) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person: " + firstName + " " + secondName + ", " + address;
    }
    public static class NullPerson extends Person implements Null {
        private NullPerson() { super("None", "None", "None");}
        public String toString() { return "NullPerson";}
    }
    public static final Person NULL = new NullPerson();
}