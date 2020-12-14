package number_systems.parseinteger;

/**
 * Class ParseIntegerExample demonstrates the way to convert the number of any number system to decimal number system.
 *
 * @author Kamila Meshcheryakova
 * created by 14.12.2020
 */
public class ParseIntegerExample {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {

        if (s.startsWith("0")) {
            if (s.startsWith("0x")) {
                return "" + Integer.parseInt(s.split("0x")[1], 16);
            }
            else if (s.startsWith("0b")) {
                return "" + Integer.parseInt(s.split("0b")[1], 2);
            } else return "" + Integer.parseInt(s, 8);
        }

        return "" + Integer.parseInt(s, 10);
    }
}
