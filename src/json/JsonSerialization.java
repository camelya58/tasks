package json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;

/**
 * Class JsonSerialization demonstrates converting of java object to JSON.
 *
 * How to include jackson libraries to project:
 * 1. download the following dependencies from link - https://mvnrepository.com/artifact/com.fasterxml.jackson.core.
 *  - Jackson Databind;
 *  - Jackson Core;
 *  - Jackson Annotations;
 *
 * 2. Go to directories in IntelliJ Idea and add downloaded dependencies from disk:
 *  File → Project Structure → Modules  → Dependencies → + (right)  → Jars or directories (select your jars) and apply.
 *
 * 3. Go to:
 * File → Project Structure → Libraries → From Maven  → find "com.fasterxml.jackson.core:jackson-databind" and apply.
 *
 * @author Kamila Meshcheryakova
 * created by 10.09.2020
 */
public class JsonSerialization {
    public static void main(String[] args) throws IOException
    {
        // object creation for mapping to JSON
        Cat cat = new Cat();
        cat.name = "Murka";
        cat.age = 5;
        cat.weight = 4;

        // write the result of mapping to Writer(StringWriter)
        StringWriter writer = new StringWriter();

        // Jackson object which do mapping of objects
        ObjectMapper mapper = new ObjectMapper();

        // the method allows to map : 1 - where, 2 - what
        mapper.writeValue(writer, cat);

        //get the String from StringWriter
        String result = writer.toString();
        System.out.println(result);
    }
}
