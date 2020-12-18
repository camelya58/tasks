package math_square;

/**
 * Class MaxMatrixSquare demonstrates how to compute max square of square which consists only from 1 in matrix.
 *
 * @author Kamila Meshcheryakova
 * created by 18.12.2020
 */
public class MaxMatrixSquare {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 1, 1, 1, 0, 1, 0, 0, 1, 1},
                {1, 0, 1, 1, 0, 1, 0, 0, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 1, 0, 1, 1, 1}
        };
        // max square is 25
        System.out.println(maxSquare(matrix));
    }

    public static int maxSquare(int[][] matrix) {
        int max = 0;
        // create new matrix which more large (by 1) of given matrix
        // it consists from default meanings (0)
        int[][] newMatrix = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                // the we check if the cell of matrix has value as 0 we fill 0 in new matrix
                if (matrix[i][j] == 0) {
                    newMatrix[i + 1][j + 1] = 0;
                } else {
                    // if the cell of given matrix has 1 than
                    // we need to find min value between neighbors from left and up and add 1
                    newMatrix[i + 1][j + 1] = Math.min(newMatrix[i + 1][j], Math.min(newMatrix[i][j], newMatrix[i][j + 1])) + 1;
                    if (newMatrix[i + 1][j + 1] > max) {
                        max = newMatrix[i + 1][j + 1];
                    }
                }
            }
        }
        return max * max;
    }

}
