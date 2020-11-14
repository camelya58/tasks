package jaxb_xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

/**
 * Class JaxbSerialization demonstrates serialization from java object to xml using jaxb.
 *
 *  How to include jaxb libraries to project:
 *  1. download the following dependencies from links -
 *  - https://mvnrepository.com/artifact/javax.xml.bind/jaxb-api/2.3.1
 * - https://mvnrepository.com/search?q=com.sun.xml.bind
 * - https://mvnrepository.com/artifact/javax.xml.bind/activation/1.0.2
 *
 *  2. Go to directories in IntelliJ Idea and add downloaded dependency from disk:
 *  File → Project Structure → Modules  → Dependencies → + (right)  → Jars or directories (select your jar) and apply.
 *
 *
 * @author Kamila Meshcheryakova
 * created by 14.09.2020
 */
public class JaxbSerialization {
    public static void main(String[] args) throws JAXBException
    {
        //object creation for serialization in XML
        Cat cat = new Cat();
        cat.name = "Murka";
        cat.age = 5;
        cat.weight = 4;

        // create StringWriter to write the result of serialization
        StringWriter writer = new StringWriter();

        // create an object Marshaller, which completes a serialization
        JAXBContext context = JAXBContext.newInstance(Cat.class);
        Marshaller marshaller = context.createMarshaller();
        // Marshaller.JAXB_FORMATTED_OUTPUT - sets space and lines break
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        // the serialization
        marshaller.marshal(cat, writer);

        //convert StringWriter to string
        String result = writer.toString();
        System.out.println(result);
    }
}
/* Output:
<cat>
    <name>Murka</name>
    <age>5</age>
    <weight>4</weight>
</cat>
 */