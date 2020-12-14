package number_systems.biginteger;

import java.math.BigInteger;

/**
 * Class BigIntegerExample demonstrates the opportunity of BigInteger to convert the number of any number system to any number system.
 *
 * @author Kamila Meshcheryakova
 * created by 14.12.2020
 */
public class BigIntegerExample {
    public static void main(String[] args) {
        Number number = new Number(NumberSystemType._10, "6");
        Number result = convertNumberToOtherNumberSystem(number, NumberSystemType._2);
        System.out.println(result);    //expected 110

        number = new Number(NumberSystemType._16, "6df");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._8);
        System.out.println(result);    //expected 3337

        number = new Number(NumberSystemType._16, "abcdefabcdef");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._16);
        System.out.println(result);    //expected abcdefabcdef
    }

    public static Number convertNumberToOtherNumberSystem(Number number, NumberSystem expectedNumberSystem) {
        NumberSystem numberSystem = number.getNumberSystem();
        int numberType = numberSystem.getNumberSystemIntValue();
        String convertedNumber;
        int systemNumber = expectedNumberSystem.getNumberSystemIntValue();
        try {
            // the params in constructor must be: string and int type of number system (by default - 10)
            BigInteger a = new BigInteger(number.getDigit(), numberType);
            // the method toString(int type of number system) allows to convert the number to given number system
            convertedNumber = a.toString(systemNumber);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
        return new Number(expectedNumberSystem,convertedNumber);
    }
}
