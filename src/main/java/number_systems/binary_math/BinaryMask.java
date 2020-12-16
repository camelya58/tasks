package number_systems.binary_math;

/**
 * Class BinaryMask demonstrates the opportunity of binary digits.
 * The example allows to convert a binary number where all bits of 1 are replaced with 0s except the first.
 *
 * @author Kamila Meshcheryakova
 * created by 16.12.2020
 */
public class BinaryMask {
    public static void main(String[] args) {
        BinaryMask binaryMask = new BinaryMask();
        int number = Integer.MAX_VALUE - 133;
        System.out.printf("number = %d in binary system:\n%s\n\n", number, Integer.toString(number, 2));

        String result = Integer.toString(binaryMask.resetLowerBits(number), 2);
        System.out.printf("the result:\n%s\n\n", result);
    }

    public int resetLowerBits(int number) {
        number |= number >> 1;
        number |= number >> 2;
        number |= number >> 4;
        number |= number >> 8;
        number |= number >> 16;
        // short version
//        number &= ~(number >> 1);

        // long version
        System.out.printf("number after all bit-shifts to make all bits are 1:\n%s\n\n", Integer.toBinaryString(number));
        int n = number;
        number = number >> 1;
        System.out.printf("number after bit-shift (number >> 1) to get 0 at the beginning:\n%s\n\n", Integer.toBinaryString(number));
        int m = ~number;
        System.out.printf("number after NOT (~number) to get 1 at the beginning:\n%s\n\n", Integer.toBinaryString(m));
        number = n & m;
        System.out.printf("a binary number where all bits of 1 are replaced with 0s except the first:\n" +
                        "compare (&) the number:\n%s and the number\n%s to get number\n%s\n\n",
                Integer.toBinaryString(n), Integer.toBinaryString(m), Integer.toBinaryString(number));
        return number;
    }
}