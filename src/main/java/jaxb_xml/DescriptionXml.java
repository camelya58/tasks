package jaxb_xml;

/**
 * Class DescriptionXml
 *
 * Xml contains from tags:
 * - opening tag with closing tag "<data></data>";
 * - opening tag with auto-closing tag "<data/>".
 *
 * The difference is that you can't use nested tags inside second way.
 *
 * Nested tags:
 * "<data>
 *     <owner>
 *         <cat name="Tom" age="15"/>
 *     </owner>
 * </data>".
 *
 * Tags can have attributes (name and age) "<cat name="Tom" age="15"/>".
 *
 * Tags can mix text with nested tags:
 * "<info>
 *     Some text
 *     <data year="2020" month="07" day="01"></data>
 *     Other text
 *     <data hour="01" minutes="34" seconds="04"></data>
 *     Another text
 * </info>".
 *
 * There are no reserved names for tags.
 * But tags have namespace for unique names:
 * "<animal:cat></animal:cat>
 * <zoo:cat></zoo:cat>".
 *
 * You can write the unique long name of namespace in import:
 * "<data xmlns:soap="http://cxf.apache.org/bindings/soap">
 *  <soap:item>
 *      <soap:info/>
 *  </soap:item>
 *  </data>".
 *
 * (xmlns - XML NameSpace)
 *
 * As well as xml has header with version and encoding:
 * "<?xml version="1.0" encoding="UTF-8"?>".
 *
 * You can add comments:
 * "<!-- it is a comment -->".
 *
 * Due to the fact that xml has several symbols like "&<>', they must be replaced with another text:
 * & - &amp;
 * " - &quot;
 * < - &lt;
 * > - &gt;
 * ' - &apos;.
 *
 * @author Kamila Meshcheryakova
 * created by 14.09.2020
 */
public class DescriptionXml {
    public static void main(String[] args) {
        int a = 4, b = 5;
        if (a < b) System.out.println("a is minimum");
        /*
        in xml:
        <code>
        if (a &lt; b) System.out.println(&quot;a is minimum&quot;);
        </code>
         */
    }
}
