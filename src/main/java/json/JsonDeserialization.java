package json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Class JsonDeserialization demonstrates converting main.java.json.json object to java object.
 *
 * Array, ArrayList, LinkedList replace to array in JSON-format.
 * So you need to rely on jackson and let him select or you can add annotation @JsonDeserialize(as = LinkedList.class).
 *
 * @author Kamila Meshcheryakova
 * created by 10.09.2020
 */
public class JsonDeserialization {
    public static void main(String[] args) throws IOException {
        String jsonString = "{\"name\":\"Spike\",\"dogs\":[{\"name\":\"Taffy\"},{\"name\":\"Killer\"}]}";
        ObjectMapper mapper = new ObjectMapper();
        Dog dog = mapper.readValue(jsonString, Dog.class);
        System.out.println(dog.name);
        System.out.println(dog.dogs.getClass());
    }
}
/* Output without annotation:
Spike
class java.util.ArrayList

Output with annotation:
Spike
class java.util.LinkedList
 */
