package jaxb_xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

/**
 * Class JaxbDeserialization demonstrates serialization from xml to java object using jaxb.
 *
 * @author Kamila Meshcheryakova
 * created by 14.09.2020
 */
public class JaxbDeserialization {
    public static void main(String[] args) throws JAXBException {
        String xmldata = "<cat><name>Murka</name><age>5</age><weight>4</weight></cat>";
        StringReader reader = new StringReader(xmldata);

        JAXBContext context = JAXBContext.newInstance(Cat.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        Cat cat = (Cat) unmarshaller.unmarshal(reader);
        System.out.println(cat);
    }
}
/* Output:
Cat{name='Murka', age=5, weight=4}
 */