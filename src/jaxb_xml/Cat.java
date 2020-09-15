package jaxb_xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Class Cat
 * @XmlRootElement allows to set that it can be the "root of a tree".
 * @XmlType(name = «cat») mark as a JAXB serialization and set a name of tag.
 *
 * @author Kamila Meshcheryakova
 * created by 14.09.2020
 */
@XmlType(name = "cat")
@XmlRootElement
public class Cat {
    @XmlElement
    String name;
    @XmlElement
    int age;
    @XmlElement
    int weight;

    public Cat(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public Cat() {
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }
}
