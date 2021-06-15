package BackTracking;

import java.util.Arrays;

public class BackTracking1 {
    /*Input : arr[] = 2, 4, 6, 8
            x = 8
Output : [2, 2, 2, 2]
         [2, 2, 4]
         [2, 6]
         [4, 4]
         [8]*/
    public static void combinationalSum(int[] arr, int sum, int[] ansArr, int ansIndex) {
        if (Arrays.stream(ansArr).sum() == sum) {
            System.out.println(Arrays.toString(ansArr));
            return;
        }
        if (ansIndex >= arr.length) return;
        for (int i = 0; i < arr.length; i++) {
            if(ansArr[ansIndex-1 < 0?0:ansIndex-1] <= arr[i]) {
                ansArr[ansIndex] = arr[i];
                combinationalSum(arr, sum, ansArr, ansIndex+1);
                ansArr[ansIndex] = 0;
            }
        }
    }

    private static boolean checkSort(int[] ansArr) {
        for (int i = 0; i < ansArr.length - 2; i++) {
            if (ansArr[i] > ansArr[i + 1]) return false;
        }
        return true;
    }

    static int max = 0;
    private static void longestPath(int[][] grid, int r,int c, int i, int j, boolean[][] visited, String ans) {
        if (i == r - 1 && j == c - 1) {
            if (max < ans.length()) {
                max = ans.length();
                displayLongestPath(visited, r, c);
                System.out.println(ans + " " + max);
                return;
            }
        }
        if(!isItSafe(grid, visited, r, c, i, j)) return;
        visited[i][j] = true;
        if(isItSafe(grid, visited, r, c,i-1, j)) longestPath(grid, r, c, i - 1, j, visited, ans + "U");
        if(isItSafe(grid, visited, r, c,i+1, j)) longestPath(grid, r, c,i + 1, j, visited, ans + "D");
        if(isItSafe(grid, visited, r, c, i, j+1)) longestPath(grid, r, c, i, j + 1, visited, ans + "R");
        if(isItSafe(grid, visited, r, c, i, j-1)) longestPath(grid, r, c, i, j - 1, visited, ans + "L");
        visited[i][j] = false;
    }

    private static boolean isItSafe(int[][] grid, boolean[][] visited, int r, int c,  int i, int j) {
        return i>=0 && j>=0 && i<r && j<c && !visited[i][j] && grid[i][j] == 1;
    }

    private static void displayLongestPath(boolean[][] visited, int r, int c) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(visited[i][j])
                    System.out.print("1" + " ");
                else System.out.print("." + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        /*int[] arr = {2, 4, 6, 8};
        combinationalSum(arr, 8, new int[arr.length], 0);*/

        int [][] mat = {{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
        { 1, 1, 0, 1, 1, 0, 1, 1, 0, 1 },
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }};
        boolean[][] visited = new boolean[3][10];
        longestPath(mat, 3, 10, 0, 0, visited, "");
    }
}
