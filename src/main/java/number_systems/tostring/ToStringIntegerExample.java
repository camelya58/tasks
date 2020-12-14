package number_systems.tostring;

import java.util.HashSet;
import java.util.Set;

/**
 * Class ToStringIntegerExample demonstrates the way to convert the number of any number system to decimal number system.
 *
 * @author Kamila Meshcheryakova
 * created by 14.12.2020
 */
public class ToStringIntegerExample {
    public static void main(String[] args) {
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
    }

    private static Set<Integer> getRadix(String s) {
        Set<Integer> set = new HashSet<>();
        for (int i = 2; i <= 36; i++) {
            String palindrome;
            try {
               palindrome = Integer.toString(Integer.parseInt(s), i);
            } catch (NumberFormatException e) {
                return set;
            }
            StringBuilder sb = new StringBuilder(palindrome);
            if (palindrome.equals(sb.reverse().toString())) {
                set.add(i);
            }
        }
        return set;
    }
}