package binary_math;

/**
 * Class GetAddress demonstrates how to determine the net address.
 *
 * @author Kamila Meshcheryakova
 * created 13.11.2020
 */
public class GetAddress {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] address = new byte[4];
        for (int i = 0; i < address.length; i++) {
            int num =  ip[i] & mask[i];
            address[i] = (byte) num;
        }
        return address;
    }

    public static void print(byte[] bytes) {
        for (byte b: bytes) {
            int a = Byte.toUnsignedInt(b);
            String str = String.format("%8s", Integer.toBinaryString(a)).replaceAll(" ", "0");
            System.out.print(str + " ");
        }
        System.out.println();
    }
}
