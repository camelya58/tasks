package maths_with_recursion;

/**
 * Class Factorization demonstrates how recursion works to find simple multipliers of number:
 *  when 1 doesn't have any multipliers
 *  and first multiplier starts with 2.
 *
 * @author Kamila Meshcheryakova
 * created by 25.09.2020
 */
public class Factorization {
    public void recurse(int n) {
        // starts from 2
        int m = 2;
        while (m <= n) { // work for number more than 1
            if (n % m == 0) { // if number can be divisible by m without remainder
                if (m != n) {
                    System.out.print(m + " ");
                    recurse(n /= m);
                } else {
                    System.out.print(m);
                }
                return;
            }
            m++;
        }
    }

    public static void main(String[] args) {
        Factorization solution = new Factorization();
        solution.recurse(132);

    }
}
