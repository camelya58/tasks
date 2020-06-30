package Regex_Pattern_Matcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class TestRegularExpression represents test regular expressions
 * using classes Pattern and Matcher and the methods of Matcher like find() and group().
 *
 * @author Kamila Meshcheryakova
 * created by 29.06.2020
 */
// {Args: abcabcabcdefabc "abc+" "(abc)+" "(abc){2,}" }
public class TestRegularExpression {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage:\njava TestRegularExpression " +
                    "characterSequence regularExpression+");
            System.exit(0);
        }
        System.out.println("Input: \"" + args[0] + "\"");
        for(String arg : args) {
            System.out.println("Regular expression: \"" + arg + "\"");
            // regex - arg = {"abc+", "(abc)+", "(abc){2,}"}
            Pattern p = Pattern.compile(arg);
            // incoming string - arg[0] = "abcabcabcdefabc";
            Matcher m = p.matcher(args[0]);
            // the method "find()" find the regex in a string
            while (m.find()) {
                // the method "group()" find the first coincidence with regex, than next ... and the last
                System.out.println("Match \"" + m.group() + "\" at positions " +
                        m.start() + "-" + (m.end()-1));
            }
            if (m.lookingAt())
                System.out.println("lookingAt() start = "
                        + m.start() + " end = " + m.end());
            //
            if (m.matches())
                System.out.println("matches() start = "
                        + m.start() + " end = " + m.end());
        }
    }
} /* Output:
    Input: "abcabcabcdefabc"
Regular expression: "abcabcabcdefabc"
Match "abcabcabcdefabc" at positions 0-14
Regular expression: "abc+"
Match "abc" at positions 0-2
Match "abc" at positions 3-5
Match "abc" at positions 6-8
Match "abc" at positions 12-14
Regular expression: "(abc)+"
Match "abcabcabc" at positions 0-8
Match "abc" at positions 12-14
Regular expression: "(abc){2,}"
Match "abcabcabc" at positions 0-8
*/
