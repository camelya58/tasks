package maths_with_recursion;

/**
 * Class Factorial demonstrates how recursion works to find the factorial of number:
 * when 0 and 1 equals to 1 and another number equals to the multiplication of all previous numbers.
 *
 * @author Kamila Meshcheryakova
 * created by 25.09.2020
 */
public class Factorial {
    public static void main(String[] args) {
        Factorial solution = new Factorial();

        System.out.println(solution.factorial(9));     //362880
        System.out.println(solution.factorial(0));     //1
        System.out.println(solution.factorial(1));     //1
    }

    public int factorial(int n) {
        if (n < 2) {
            return 1;
        } else {
            return n*factorial(n-1);
        }
    }
}
