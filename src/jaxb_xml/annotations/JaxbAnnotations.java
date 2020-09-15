package jaxb_xml.annotations;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Class JaxbAnnotations
 *
 * @XmlElement(name) Ставится около поля. Поле будет представлено в XML-элементом.
 * Позволяет задать имя для тэга.
 * @XmlAttribute(name) Ставится около поля. Поле будет представлено в XML-атрибутом!
 * Позволяет задать имя для атрибута.
 * @XmlElementWrapper(nillable = true)	Ставится около поля.
 * Позволяет задать «обрамляющий тег» для группы элементов.
 * @XmlType Ставится около класса.
 * Позволяет задать метод для создания объекта, если конструктор по умолчанию private.
 * @XmlJavaTypeAdapter Ставится около поля.
 * Позволяет задать класс, который будет преобразовывать данные поля в строку.
 *
 * @author Kamila Meshcheryakova
 * created by 14.09.2020
 */
public class JaxbAnnotations {

    public static void main(String[] args) throws JAXBException {
        //создание объектов Cat&Zoo для сериализации в XML
        Cat cat = new Cat();
        cat.name = "Murka";
        cat.age = 5;
        cat.weight = 4;

        Zoo zoo = new Zoo();
        //Объект cat в коллекцию был добавлен дважды, поэтому он 2 раза в XML.
        zoo.animals.add(cat);
        zoo.animals.add(cat);

        //писать результат сериализации будем во Writer(StringWriter)
        StringWriter writer = new StringWriter();

        //создание объекта Marshaller, который выполняет сериализацию
        // мы передаем в JAXB-контекст два класса – Zoo & Cat, т.к. они оба участвуют в сериализации.
        JAXBContext context = JAXBContext.newInstance(Cat.class, Zoo.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        // самосериализация
        marshaller.marshal(zoo, writer);

        //преобразовываем все записанное в StringWriter в строку
        System.out.println(writer.toString());
    }
}
// мы сериализуем не объект Cat, а объект типа Zoo, которых хранит коллекцию объектов Cat.
@XmlType(name = "zoo")
@XmlRootElement
class Zoo {
    //У коллекции есть свой тег – «wild-animals» , который обрамляет все элементы коллекции.
    @XmlElementWrapper(name="wild-animals", nillable = true)
    public List<Animal> animals = new ArrayList<>();
}
//С помощью атрибута @XmlType мы поменяли тэг cat на tiger.
@XmlType(name = "tiger")
class Cat extends Animal {
    @XmlElement(name = "catname")
    public String name;
    //Элементы age & weight стали атрибутами age &w.
    @XmlAttribute(name = "age")
    public int age;
    @XmlAttribute(name = "w")
    public int weight;

    Cat() {}
}

abstract class Animal {}
/* Output:
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<zoo>
    <wild-animals>
        <animals xsi:type="tiger" age="5" w="4" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
            <catname>Murka</catname>
        </animals>
        <animals xsi:type="tiger" age="5" w="4" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
            <catname>Murka</catname>
        </animals>
    </wild-animals>
</zoo>
 */