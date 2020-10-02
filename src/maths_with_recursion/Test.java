package maths_with_recursion;

import java.io.*;

/**
 * Class Test
 *
 * @author Kamila Meshcheryakova
 * created by 29.09.2020
 */
public class Test {
    private static String[][] testArray = new String[][] {
            { "0.001 + 0", "0 : 1" },
            { "0.005 - 0", "0.01 : 1" },
            { "2 + 3", "5 : 1" },
            { "(-5)",  "-5 : 1" },
            { "(-5)*(-4)", "20 : 3" },
            { "2 ^ 0.5", "1.41 : 1" },
            { "3 ^ 0.5", "1.73 : 1" },
            { "-2^(-2)", "-0.25 : 3" },
            { "(-2)^(-2)", "0.25 : 3" },
            { "(1/3)*(5/8)", "0.21 : 3" },
            { "2*0.5^2+3*0.5+4", "6 : 5" },
            { "-((1/3)^((5/8)*42.42^0.0002)+2/7)", "-0.79 : 8" },

            { "sin(30)", "0.5 : 1" },
            { "cos(90)", "0 : 1" },
            { "cos(3 + 19*3)", "0.5 : 3" },
            { "sin(2*(-5+1.5*4)+28)", "0.5 : 6" },
            { "-sin(2*(-5+1.5*4)+28)", "-0.5 : 7" },
            { "tan(2025 ^ 0.5)", "1 : 2" },
            { "sin(3.14/2)^2 + cos(3.14/2)^2", "1 : 7" },
            { "tan(45) + 35.7^(-0.16)", "1.56 : 4" },
            { "sin(2*55) - 2*sin(55)*cos(55)", "0 : 7" },
            { "(cos(2*35) + cos(35)^2 - sin(35)^2) / (1-2*(sin(35)^2))", "2 : 13" },
            { "sin(2) + sin(0.55) - 2*sin((2+0.55)/2)*cos((2-0.55)/2)", "0 : 12" },
            { "2* tan(30/2) / (sin(15.0*2.0)/(1+cos(30)) + 2 *((1-cos(30))/sin(30)))", "0.67 : 15" },
            { "- sin(1.5*2*10) + 3*sin(100^0.5) - 4*sin(10)^3", "0 : 12" },
            { "sin(cos(60)*60)*cos(45) * tan(56.25) / ((sin(30+45)+sin(30-45))/cos(60)*2.0^2.0)", "0.09 : 17" },
            { "((2*tan(10/2)/(1+tan(10/2)^2))^2 + ((1-tan(10/2)^2)/(1+tan(10/2)^2))^2) / (-3)", "-0.33 : 22" }
    };

    public static void main(String[] args) {
        ParseRecursion solution = new ParseRecursion();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);

        PrintStream systemOut = System.out;

        for (String[] strings : testArray) {
            try {
                System.setOut(printStream);
                solution.recurse(strings[0], 0);
                ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
                BufferedReader reader = new BufferedReader(new InputStreamReader(bais));
                System.setOut(systemOut);
                String actual = reader.readLine();
                baos.reset();
                if (actual.equals(strings[1].replace(" :", ""))) {
                    System.out.println("TEST PASSED: "
                            + strings[0] + " " + strings[1] + " [" + actual + "]");
                } else {
                    System.out.println("\033[31mTEST FAILED: "
                            + strings[0] + " " + strings[1] + " [" + actual + "]\033[0m");
                }
            } catch (Exception e) {
                System.setOut(systemOut);
                System.out.println("\033[31mTEST FAILED: "
                        + strings[0] + " : " + e.getMessage() + " at line "
                        + e.getStackTrace()[1].getLineNumber() + "]\033[0m");
            }
        }
    }
}
