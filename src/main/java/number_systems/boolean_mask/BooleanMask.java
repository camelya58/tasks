package number_systems.boolean_mask;

/**
 * Class BooleanMask demonstrates the opportunity to set 7 boolean values in one byte variable and to get the values.
 *
 * @author Kamila Meshcheryakova
 * created by 16.12.2020
 */
public class BooleanMask {
    public static void main(String[] args) {
        /*
        Cat's properties (max 7 params):
        1. Is it tom cat or pussy cat? (true or false)
        2. Does it has a long tail or not? (true or false)
        3. Is it tender or not? (true or false)
        4. Is it lazy or not? (true or false)
        5. Is it yong or not? (true or false)
        6. Is it varicoloured or not? (true or false)
        7. Is it fat or not? (true or false)
         */
        // take a one byte (empty)
        byte catProperties = 0b00000000;

        // set the first byte - the sex of the cat as true (tom cat)
        catProperties |= 0b00000001;
/*
        Operator | will compare the original number and the given by bytes:
        00000000
        00000001
        -------------
        00000001 - the result
 */
        // make the same operations for another cat properties
        catProperties |= 0b00000010; // set long tail (second bit - true)
        catProperties &= 0b11111011; // set not tender (third bit - false)
        catProperties |= 0b00001000; // set lazy (fourth bit - true)
        catProperties |= 0b00010000; // set young (fifth bit - true)
        catProperties &= 0b11011111; // set not varicoloured (sixth bit - false)
        catProperties |= 0b01000000; // set lazy (seventh bit - true)
        System.out.println(Integer.toString(catProperties, 2));

        /*
        01011011 - the result (true, true, false, true, true, false, true)
         */

        // now we can get the information about the sex
        boolean isTomCat = ((catProperties & 0b00000001) == 1);
        System.out.println("Is it tom cat? - " + isTomCat);

        boolean isLong = ((catProperties & 0b00000010) == 2);
        System.out.println("Does it has a long tail? - " + isLong);

        boolean isTender = ((catProperties & 0b00000100) == 4);
        System.out.println("Is it tender? - " + isTender);

        boolean isLazy = ((catProperties & 0b00001000) == 8);
        System.out.println("Is it lazy? - " + isLazy);

        boolean isYoung = ((catProperties & 0b00010000) == 16);
        System.out.println("Is it yong? - " + isYoung);

        boolean isVaricoloured = ((catProperties & 0b00100000) == 32);
        System.out.println("Is it varicoloured? - " + isVaricoloured);

        boolean isFat = ((catProperties & 0b01000000) == 64);
        System.out.println("Is it fat? - " + isFat);

// the way to set the value in bit and receive the value
        int oneInBit = 0;
        oneInBit = oneInBit | (1<<6); // to set 1 to 6 bit 01000000 == 64
        //  OneInBit |= (1<<6);
        System.out.println("set 1 to 6 bit in oneInBit - " + Integer.toBinaryString(oneInBit));
        int zeroInBit = 0b11111111;
        zeroInBit = zeroInBit & ~(1<<6); // to set 0 to 6 bit
       //  zeroInBit &= ~(1<<6);
        System.out.println(" to set 0 to 6 bit in zeroInBit - " + Integer.toBinaryString(zeroInBit));
        boolean sixthBit = ((oneInBit & (1<<6)) == 64); // to get 6 bit
       // sixthBit &= (1<<6);
        System.out.println("Is 6 bit in oneInBit is 1? - " + sixthBit);
        sixthBit = ((zeroInBit & (1<<6)) == 64); // to get 6 bit
        System.out.println("Is 6 bit in zeroInBit is 1? - " + sixthBit);
    }
}
