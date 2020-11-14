package json.poly_serialization;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;

/**
 * Class PolymorphicSerialization demonstrates polymorphic serialization.
 *
 * @author Kamila Meshcheryakova
 * created by 10.09.2020
 */
public class PolymorphicSerialization {
    public static void main(String[] args) throws IOException {

        Cat cat = new Cat();
        cat.name = "Murka";
        cat.age = 5;

        Dog dog = new Dog();
        dog.name = "Killer";
        dog.age = 8;
        dog.owner = "Bill Jeferson";

        ArrayList<Pet> pets = new ArrayList<Pet>();
        pets.add(cat);
        pets.add(dog);

        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, pets);
        System.out.println(writer.toString());
    }
}
/* Output:
[{"name":"Murka","age":5},{"name":"Killer","age":8,"owner":"Bill Jeferson"}]
 */
