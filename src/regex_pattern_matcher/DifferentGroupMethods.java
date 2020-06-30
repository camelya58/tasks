package regex_pattern_matcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class DifferentGroupMethods represents test regular expressions
 * using classes Pattern and Matcher and the methods of Matcher such as
 * group(), groupCount(), group(int i).
 *
 * @author Kamila Meshcheryakova
 * created by 30.06.2020
 */
public class DifferentGroupMethods {
    public static final String POEM =
            "Tis but thy name that is my enemy;\n" +
                    "Thou art thyself, though not a Montague.\n" +
                    "What's Montague? it is nor hand, nor foot,\n" +
                    "Nor arm, nor face, nor any other part\n" +
                    "Belonging to a man. O, be some other name!\n" +
                    "What's in a name? that which we call a rose\n" +
                    "By any other name would smell as sweet;\n" +
                    "So Romeo would, were he not Romeo call'd,\n" +
                    "Retain that dear perfection which he owes\n" +
                    "Without that title. Romeo, doff thy name,\n" +
                    "And for that name which is no part of thee\n" +
                    "Take all myself.";

    public static void main(String[] args) {
        // \\S - any symbol instead of space, \\s - space, + - one or more times,
        // $ - at the end of incoming string, (?m) - allows to make $ find at the end of line considering line break
        Matcher m = Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$").
                matcher(POEM);
        while(m.find()) {
            // m.groupCount() returns the quantity of group in pattern
            for(int j = 0; j <= m.groupCount(); j++)
                // m.group(j) returns the group with the given number from the previous match search operation
                System.out.print("[" + m.group(j) + "]");
            System.out.println();
        }
    }
}

/* Output:
        [is my enemy;][is][my enemy;][my][enemy;]
        [not a Montague.][not][a Montague.][a][Montague.]
        [hand, nor foot,][hand,][nor foot,][nor][foot,]
        [any other part][any][other part][other][part]
        [some other name!][some][other name!][other][name!]
        [call a rose][call][a rose][a][rose]
        [smell as sweet;][smell][as sweet;][as][sweet;]
        [not Romeo call'd,][not][Romeo call'd,][Romeo][call'd,]
        [which he owes][which][he owes][he][owes]
        [doff thy name,][doff][thy name,][thy][name,]
        [part of thee][part][of thee][of][thee]
        [Take all myself.][Take][all myself.][all][myself.]
 */