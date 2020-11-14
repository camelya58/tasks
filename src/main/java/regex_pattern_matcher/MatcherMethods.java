package regex_pattern_matcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class MatcherMethods represents test regular expressions
 * using classes Pattern and Matcher and the methods of Matcher such as
 * start(), end(), lookingAt(), matches().
 *
 * @author Kamila Meshcheryakova
 * created by 30.06.2020
 */
public class MatcherMethods {
    public static String input =
            "As long as there is injustice, whenever a\n" +
                    "Targathian baby cries out, whenever a distress\n" +
                    "signal sounds among the stars ... We'll be there.\n" +
                    "This fine ship, and this fine crew ...\n" +
                    "Never give up! Never surrender!";

    private static class Display {
        private boolean regexPrinted = false;
        private String regex;
        Display(String regex) {
            this.regex = regex;
        }
        void display(String message) {
            if (!regexPrinted) {
                System.out.println(regex);
                regexPrinted = true;
            }
            System.out.println(message);
        }
    }
    static void examine(String s, String regex) {
        Display d = new Display(regex);
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
        // m.start() returns starting index of group which find from from the previous match search operation
        // m.end() returns index of ending symbol of group which find from from the previous match search operation
        while(m.find()) {
            d.display("find() '" + m.group() +
                    "' start = " + m.start() + " end = " + m.end());
        }
// lookingAt() always starts at the beginning of the region, it does not require matching the whole string
        if (m.lookingAt())
            d.display("lookingAt() start = "
                        + m.start() + " end = " + m.end());
        //
        if (m.matches())
            d.display("matches() start = "
                        + m.start() + " end = " + m.end());

    }

    public static void main(String[] args) {
        for (String in : input.split("\n")) {
            System.out.println("input: " + in);
            for (String regex : new String[]{"\\w*ere\\w*",
                    "\\w*ever", "T\\w+",  "Never.*?!"})
                examine(in, regex);
        }
    }

} /* Output:
input: As long as there is injustice, whenever a
\w*ere\w*
find() 'there' start = 11 end = 16
\w*ever
find() 'whenever' start = 31 end = 39
input: Targathian baby cries out, whenever a distress
\w*ever
find() 'whenever' start = 27 end = 35
T\w+
find() 'Targathian' start = 0 end = 10
lookingAt() start = 0 end = 10
input: signal sounds among the stars ... We'll be there.
\w*ere\w*
find() 'there' start = 43 end = 48
input: This fine ship, and this fine crew ...
T\w+
find() 'This' start = 0 end = 4
lookingAt() start = 0 end = 4
input: Never give up!
\w*ever
find() 'Never' start = 0 end = 5
find() 'Never' start = 15 end = 20
lookingAt() start = 0 end = 5
Never.*?!
find() 'Never give up!' start = 0 end = 14
find() 'Never surrender!' start = 15 end = 31
lookingAt() start = 0 end = 14
matches() start = 0 end = 31
*/
