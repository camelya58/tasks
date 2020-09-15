package jaxb_xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.StringWriter;

/**
 * Class ExampleSerialization represents the example of serialization from java object to xml.
 *
 * @author Kamila Meshcheryakova
 * created by 14.09.2020
 */
public class ExampleSerialization {
    public static void main(String[] args) throws JAXBException {
        Cat cat = new Cat();
        cat.name = "Murka";
        cat.age = 5;
        cat.weight = 3;

        Dog dog = new Dog();
        dog.name = "Killer";
        dog.age = 8;
        dog.owner = "Bill Jeferson";

        StringWriter writer = new StringWriter();
        convertToXml(writer, cat);
        convertToXml(writer, dog);
        System.out.println(writer.toString());
        /* expected output
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<cat>
    <name>Murka</name>
    <age>5</age>
    <weight>3</weight>
</cat>
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<dog>
    <name>Killer</name>
    <age>8</age>
    <owner>Bill Jeferson</owner>
</dog>
        */
    }

    public static void convertToXml(StringWriter writer, Object obj) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(obj, writer);
    }

    public static class Pet {
        @XmlElement
        public String name;
    }

    @XmlType(name = "cat")
    @XmlRootElement
    public static class Cat extends Pet {
        @XmlElement
        public int age;
        @XmlElement
        public int weight;
    }
    @XmlType(name = "dog")
    @XmlRootElement
    public static class Dog extends Pet {
        @XmlElement
        public int age;
        @XmlElement
        public String owner;
    }
}

