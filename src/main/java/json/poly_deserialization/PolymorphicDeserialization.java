package json.poly_deserialization;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;

/**
 * Class PolymorphicDeserialization demonstrates polymorphic deserialization.
 *
 * @author Kamila Meshcheryakova
 * created by 10.09.2020
 */
public class PolymorphicDeserialization {
    public static void main(String[] args) throws IOException {
        Cat cat = new Cat();
        cat.name = "Murka";
        cat.age = 5;

        Dog dog = new Dog();
        dog.name = "Killer";
        dog.age = 8;
        dog.owner = "Bill Jeferson";

        House house = new House();
        house.pets.add(dog);
        house.pets.add(cat);

        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, house);
        System.out.println(writer.toString());
        System.out.println("________________________________________");

        /* without annotations we receive - "MismatchedInputException".

        String jsonString0 = "{\"pets\":[\"name\":\"Killer\",\"age\":8,\"owner\":\"Bill Jeferson\"}," +
                "{\"name\":\"Murka\",\"age\":5}]}";
        ObjectMapper mapper0 = new ObjectMapper();
        House house0 = mapper0.readValue(jsonString0, House.class);
        System.out.println(house0.pets.get(0).getClass());
        System.out.println(house0.pets.get(1).getClass());

        System.out.println("________________________________________");

         */

        String jsonString = "{\"pets\":[{\"type\":\"dog\",\"name\":\"Killer\",\"age\":8,\"owner\":\"Bill Jeferson\"}," +
                "{\"type\":\"cat\",\"name\":\"Murka\",\"age\":5}]}";
        ObjectMapper mapper1 = new ObjectMapper();
        House house1 = mapper1.readValue(jsonString, House.class);
        System.out.println(house1.pets.get(0).getClass());
        System.out.println(house1.pets.get(1).getClass());
    }
}
/* Output without annotations:
{"pets":["name":"Killer","age":8,"owner":"Bill Jeferson"},{"name":"Murka","age":5}]}

Output with annotations:
{"pets":[{"type":"dog","name":"Killer","age":8,"owner":"Bill Jeferson"},{"type":"cat","name":"Murka","age":5}]}
 ________________________________________
class json.poly_deserialization.Dog
class json.poly_deserialization.Cat
 */