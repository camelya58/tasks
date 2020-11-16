package string_format;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Class StringTokenizerExample demonstrates the capabilities of the class StringTokenizer.
 *
 * @author Kamila Meshcheryakova
 * created by 16.11.2020
 */
public class StringTokenizerExample {
    public static void main(String[] args) {
        String s = "Good news everyone!";
// every char at second param is a delimiter (n/e)
        StringTokenizer tokenizer = new StringTokenizer(s, "ne");
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            System.out.println(token);
        }
        System.out.println(Arrays.toString(getTokens("level22.lesson13.task01", ".")));
    }

    public static String[] getTokens(String query, String delimiter) {
        ArrayList<String> list = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        while (tokenizer.hasMoreTokens()) {
            list.add(tokenizer.nextToken());
        }
        return list.toArray(new String[0]);
    }
}
/* Output
Good
ws
v
ryo
!
[level22, lesson13, task01]
 */