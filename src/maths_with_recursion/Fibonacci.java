package maths_with_recursion;

/**
 * Class Fibonacci demonstrates how recursion works to find Fibonacci numbers:
 * when 0 equals to 0, 1 equals to 1, and another number equals to the sum of 2 previous numbers.
 *
 * @author Kamila Meshcheryakova
 * created by 25.09.2020
 */
public class Fibonacci {

    public static void main(String[] args) {
        Fibonacci solution = new Fibonacci();

        System.out.println(solution.fibonacci(9));     //34
        System.out.println(solution.fibonacci(5));     //5
        System.out.println(solution.fibonacci(2));     //1
        System.out.println(solution.fibonacci(1));     //1
    }

    public int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        else {
            return fibonacci(n - 1) + fibonacci(n-2);
        }
    }
}
