package regex_pattern_matcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class ResetMethod represents the method of class Matcher such as reset().
 *
 * @author Kamila Meshcheryakova
 * created by 30.06.2020
 */
public class ResetMethod {
    public static void main(String[] args) {
            Matcher m = Pattern.compile("[frb][aiu][gx]").
                    matcher("fix the rug with bags");
            while(m.find())
                System.out.print(m.group() + " ");
            System.out.println();
            // this method allows to change the string
            m.reset("fix the rig with rags");
            while(m.find())
                System.out.print(m.group() + " ");
    }
}
