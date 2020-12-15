package number_systems.ternary_numeral_system;

import java.util.ArrayList;
import java.util.List;

/**
 * Class TernaryNumeralSystem demonstrates the opportunity of ternary numeral system:
 * using only exponents of three (1, 3, 9, 27, 81, 243, 2187, ...) we can display any number.
 * For example, 2019.
 * Output: 2019 =  + 3 - 9 + 81 - 243 + 2187
 *
 * @author Kamila Meshcheryakova
 * created 15.12.2020
 */
public class TernaryNumeralSystem {

    public static void main(String[] args) {
        TernaryNumeralSystem solution = new TernaryNumeralSystem();
        solution.createExpression(2019);
    }

    public void createExpression(int number) {
        StringBuilder sb = new StringBuilder(number + " = ");
        List<String> list = new ArrayList<>();
        while (number > 0) {
            int rest = number % 3;
            number = number / 3;
            if (rest == 0) {
                list.add("0");
            }
            if (rest == 1) {
                list.add(" + ");
            }
            if (rest == 2) {
                list.add(" - ");
                number += 1;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).equals("0")) {
                sb.append(list.get(i)).append((int) Math.pow(3, i));
            }
        }
        System.out.println(sb.toString());
    }
}