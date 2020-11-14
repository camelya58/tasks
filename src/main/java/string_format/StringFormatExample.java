package string_format;

import java.util.Date;

/**
 * Class StringFormatExample demonstrates the capabilities of string formatter.
 *
 * @author Kamila Meshcheryakova
 * created by 14.11.2020
 */
public class StringFormatExample {
    public static void main(String[] args) {
        // different ways to write float
        System.out.println(String.format("20 / 7 = %.2f%nExp = %.2e", 20.0 / 7.0, 10.0 / 3.0));
        //output
        //20 / 7 = 2,86
        //Exp = 3,33e+00

        // use different order of words
        System.out.println(String.format("%3$S %4$s %2$s %1$s", "code", "to", "we", "like"));
        //output
        //"WE like to code"

        // the way to write different dates
        Date date = new Date();
        System.out.printf("%1$td:%1$tm:%1$ty %1$tH:%1$tM:%tS", date);
        //output format
        //14:11:20 20:07:23
    }
}
