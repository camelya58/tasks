package jaxb_xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class First
 *
 * @author Kamila Meshcheryakova
 * created by 22.09.2020
 */
@XmlRootElement
public class First {
    @XmlElement
    public String[] second;
}
