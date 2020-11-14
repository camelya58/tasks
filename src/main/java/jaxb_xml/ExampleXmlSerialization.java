package jaxb_xml;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.util.stream.IntStream;

/**
 * Class ExampleXmlSerialization demonstrates how to get xml from java object and set comments before
 * specific tag
 *
 * @author Kamila Meshcheryakova
 * created by 22.09.2020
 */
public class ExampleXmlSerialization {
    public static String toXmlWithComment(Object obj, String tagName, String comment) {

        // create StringWriter to display the result
        StringWriter writer = new StringWriter();

        try {
            // create DocumentBuilderFactory which allows to create DocumentBuilder
            DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
            //true if the parser produced will convert CDATA nodes to Text nodes
            dbfac.setCoalescing(true);
            // create DocumentBuilder which allows to create Document
            DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
            // create Document which allows to get xml document
            Document doc = docBuilder.newDocument();

            // create JAXBContext which allows to get xml from object
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            // write xml to Document
            marshaller.marshal(obj, doc);
            // get list of nodes with tagName
            NodeList nodeList = doc.getElementsByTagName(tagName);
            //before each node add a comment
            IntStream.range(0, nodeList.getLength()).boxed().map(nodeList::item).forEach(node -> {
                node.getParentNode().insertBefore(doc.createComment(comment), node);
            });
            // create TransformerFactory which allows to create Transformer
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            // create Transformer which allows to transformer one xml to another and adds to writer
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "no");
            transformer.transform(new DOMSource(doc), new StreamResult(writer));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return writer.toString();
    }

    public static void main(String[] args) {
        First firstSecondObject = new First();
        firstSecondObject.second = new String[3];
        firstSecondObject.second[0] = "First phrase";
        firstSecondObject.second[1] = "Second phrase";
        firstSecondObject.second[2] = "Third phrase";
        System.out.println(toXmlWithComment(firstSecondObject, "second", "it's a comment"));
    }
}
/* Output:

<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<first>
    <!--it's a comment-->
    <second>First phrase</second>
    <!--it's a comment-->
    <second>Second phrase</second>
    <!--it's a comment-->
    <second>Third phrase</second>
</first>
 */
