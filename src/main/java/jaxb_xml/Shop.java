package jaxb_xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;
import java.util.List;

/**
 * Class Shop
 *
 * @author Kamila Meshcheryakova
 * created by 22.09.2020
 */
@XmlRootElement
public class Shop {
    @XmlElement
    public Goods goods;
    @XmlElement
    public int count;
    @XmlElement
    public double profit;
    @XmlElement
    public String[] secretData;

    @XmlType
    public static class Goods {
        public List<String> names;

        @Override
        public String toString() {
            return "Goods{" +
                    "names=" + names +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Shop{" +
                "goods=" + goods +
                ", count=" + count +
                ", profit=" + profit +
                ", secretData=" + Arrays.toString(secretData) +
                '}';
    }
}
