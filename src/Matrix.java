public class Matrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {1, 2, 3, 4},
                {5, 6, 7, 8}};
        printDiagonals(matrix);
    }

    private static void printDiagonals(int[][] arr) {
        int k = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][i] + " ");
            System.out.println(arr[i][k]);
            k--;
        }
    }
}