import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class Main
 *
 * @author Kamila Meshcheryakova
 * created by 25.09.2020
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.recurse("sin(2*(-5+1.5*4)+28)", 0); //expected output 0.5 6
    }

    public void recurse(final String expression, int countOperation) {
        double decision = 0.0;
        System.out.println("expression = " + expression);
        Pattern pattern = Pattern.compile("[-+*^]|[a-z]{3}"); //"sin(2*(-5+1.5*4)+28)"
        Matcher matcher = pattern.matcher(expression);
        while (matcher.find()) {
            //  System.out.println(matcher.group());
            countOperation++;
        }
        if (expression.matches("[a-z]{3}+\\([\\.0-9-+*^]++\\)")) {
            String function = expression.substring(0, 3);
            System.out.println(function);
            String str = expression.substring(expression.indexOf("(") + 1, expression.indexOf(")"));
            System.out.println(str);
            String[] numbers = str.split("[-+*^]");
            String sign = str.substring(numbers[0].length(), numbers[0].length() + 1);
            System.out.println(sign);
            double number1 = Double.parseDouble(numbers[0]);
            double number2 = Double.parseDouble(numbers[1]);
            double number3 = Double.parseDouble(numbers[2]);
            double degree = 0;
            switch (sign) {
                case "+":
                    degree = number1 + number2;
                    break;
                case "-":
                    degree = number1 - number2;
                    break;
                case "*":
                    degree = number1 * number2;
                    break;
                case "^":
                    degree = Math.pow(number1, number2);
                    break;
            }
            System.out.println("degree = " + degree);
            switch (function) {
                case "sin":
                    decision = Math.sin(Math.toRadians(degree));
                    break;
                case "cos":
                    decision = Math.cos(Math.toRadians(degree));
                    break;
                case "tan":
                    decision = Math.tan(Math.toRadians(degree));
                    break;
            }

            System.out.println("decision = " + decision);
        } else {
            String partOne = expression.substring(0, expression.lastIndexOf("("));
            String partTwo = expression.substring(expression.indexOf(")") + 1);
            System.out.println("partOne = " + partOne);
            System.out.println("partTwo = " + partTwo);
            String inBrackets = expression.substring(expression.lastIndexOf("(") +1, expression.indexOf(")"));
            System.out.println("inBrackets = " + inBrackets);
            String[] numbers = inBrackets.split("[-+*^]");
            if (numbers[0].equals("")) numbers[0] = "0";
            String[] signs = inBrackets.split("\\d\\.\\d|[0-9]");
            System.out.println("numbers = " + Arrays.toString(numbers));
            System.out.println("signs = " + Arrays.toString(signs));

            List<String> numbersList = new ArrayList<>(Arrays.asList(numbers));
            List<String> signsList = new ArrayList<>(Arrays.asList(signs));

            int indexMult = -1;
            int indexSqr = -1;
            int indexPlus = -1;
            int indexMinus = -1;

            if (signsList.contains("*")) indexMult = signsList.indexOf("*");
            if (signsList.contains("+")) indexPlus = signsList.indexOf("+");
            if (signsList.contains("-")) indexMinus = signsList.indexOf("-");
            if (signsList.contains("^")) indexSqr = signsList.indexOf("^");

            double one = 0;
            System.out.println("indexMult = " + indexMult);
            if (indexMult >= 0) {
                one = Double.parseDouble(numbersList.get(indexMult)) * Double.parseDouble(numbersList.get(indexMult+1));
                numbersList.remove(indexMult+1);
                numbersList.remove(indexMult);
                numbersList.add(indexMult, String.valueOf(one));
                numbersList.add(indexMult+1, "0");
            }
            System.out.println("one = " + one);

            double two = 0;
            System.out.println("indexSqr = " + indexSqr);
            if (indexSqr >= 0) {
                two = Math.pow(Double.parseDouble(numbersList.get(indexSqr)), Double.parseDouble(numbersList.get(indexSqr+1)));
                numbersList.remove(indexSqr+1);
                numbersList.remove(indexSqr);
                numbersList.add(indexSqr, String.valueOf(two));
                numbersList.add(indexSqr+1, "0");
            }
            System.out.println("two = " + two);

            double three = 0;
            System.out.println("indexMinus = " + indexMinus);
            if (indexMinus >= 0) {
                three = Double.parseDouble(numbersList.get(indexMinus)) - Double.parseDouble(numbersList.get(indexMinus+1));
                numbersList.remove(indexMinus+1);
                numbersList.remove(indexMinus);
                numbersList.add(indexMinus, String.valueOf(three));
                numbersList.add(indexMinus+1, "0");
            }
            System.out.println("three = " + three);

            double four = 0;
            System.out.println("indexPlus = " + indexPlus);
            if (indexPlus >= 0) {
                four = Double.parseDouble(numbersList.get(indexPlus)) + Double.parseDouble(numbersList.get(indexPlus+1));
                numbersList.remove(indexPlus+1);
                numbersList.remove(indexPlus);
                numbersList.add(indexPlus, String.valueOf(four));
                numbersList.add(indexPlus+1, "0");
            }
            System.out.println("four = " + four);

            double result = four + three;
            String newExpression = partOne + result + partTwo;
            System.out.println("newExpression = " + newExpression);
            recurse(newExpression, countOperation);
        }

        BigDecimal bd = new BigDecimal(Double.toString(decision)).setScale(2, RoundingMode.HALF_UP);;
        System.out.print(bd + " ");
        System.out.print(countOperation);
        //implement
    }

    public Solution() {
        //don't delete
    }
}
