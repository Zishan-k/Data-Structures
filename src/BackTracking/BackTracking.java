package BackTracking;

import java.util.*;

public class BackTracking {

    private static String swapStringChars(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }

    private static void permutation(String str, int j) {
        if (j == str.length() - 1) {
            System.out.println(str);
            return;
        }
        for (int i = j; i < str.length(); i++) {
            str = swapStringChars(str, i, j);
            permutation(str, j + 1);
            str = swapStringChars(str, i, j);
        }
    }


    private static boolean isItSafe(int[][] arr, int n, int i, int j, boolean[][] visited) {
        return i >= 0 && j >= 0 && i < n && j < n && !visited[i][j] && arr[i][j] != 0;
    }

    static int totalPaths = 0;

    private static void findTotalPathsHelper(int[][] arr, int n, int i, int j, boolean[][] visited, String ans) {
        if (i == n - 1 && j == n - 1) {
            System.out.println(ans);
            totalPaths++;
            return;
        }
        if (!isItSafe(arr, n, i, j, visited)) return;
        visited[i][j] = true;
        if (isItSafe(arr, n, i - 1, j, visited)) findTotalPathsHelper(arr, n, i - 1, j, visited, ans + "U");
        if (isItSafe(arr, n, i, j + 1, visited)) findTotalPathsHelper(arr, n, i, j + 1, visited, ans + "R");
        if (isItSafe(arr, n, i, j - 1, visited)) findTotalPathsHelper(arr, n, i, j - 1, visited, ans + "L");
        if (isItSafe(arr, n, i + 1, j, visited)) findTotalPathsHelper(arr, n, i + 1, j, visited, ans + "D");
        visited[i][j] = false;
    }

    private static int findTotalPaths(int[][] arr) {
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        int n = arr.length;
        findTotalPathsHelper(arr, n, 0, 0, visited, "");
        return totalPaths;
    }

    private static void subsetBackTrack(int[] arr, int i, int length, List<Integer> temp) {
        if (i == length) {
            System.out.println(temp);
            return;
        }
        temp.add(arr[i]);
        subsetBackTrack(arr, i + 1, length, temp);
        temp.remove(temp.size() - 1);
        subsetBackTrack(arr, i + 1, length, temp);
    }

    /*--------------------------------------------------------------------------------------------------------------*/
    private static void displayQueen(boolean[][] grid, int n) {
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]) System.out.print("Q" + " ");
                else System.out.print("." + " ");
            }
            System.out.println();
        }
    }

    private static boolean isItSafeForQueen(boolean[][] grid, int row, int col, int n) {
        // Upward: If there is any queen in the same column(upwards)
        for (int i = row - 1; i >= 0; i--)
            if (grid[i][col]) return false;
        //Left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (grid[i][j]) return false;
        //Right Diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++)
            if (grid[i][j]) return false;

        return true;
    }

    static int queenWaysCount = 0;

    private static void countWaysToPlaceNQueens(boolean[][] grid, int row, int n) {
        if (row == n) {
            queenWaysCount++;
            displayQueen(grid, n);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isItSafeForQueen(grid, row, i, n)) {
                grid[row][i] = true;
                countWaysToPlaceNQueens(grid, row + 1, n);
                grid[row][i] = false;
            }
        }
    }

    //----------------------------------------------------------------------------------------------------
    private static void displayKnightsWays(int[][] grid, int n) {
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isItSafeForKnight(int[][] grid, int i, int j, int n, boolean[][] visited) {
        return i >= 0 && j >= 0 && i < n && j < n && !visited[i][j];
    }

    private static void knightsWays(int[][] grid, int n, int i, int j, int knightStepCount, boolean[][] visited) {
        if (knightStepCount == (n * n) - 1) {
            displayKnightsWays(grid, n);
            return;
        }
        if (knightStepCount >= n * n) return;

        int[] x = {-2, -2, -1, 1, 2, 2, 1, -1};
        int[] y = {-1, 1, 2, 2, 1, -1, -2, -2};
        visited[i][j] = true;
        grid[i][j] = knightStepCount;
        for (int k = 0; k < 8; k++) {
            if (isItSafeForKnight(grid, i + x[k], j + y[k], n, visited)) {
                knightsWays(grid, n, i + x[k], j + y[k], knightStepCount + 1, visited);
            }
        }
        visited[i][j] = false;
        grid[i][j] = 0;
    }

    //---------------------------------------------------------------------------------------------------------------
    private static void countWaysToPlaceNQueensOpt(boolean[][] grid, int row, int n, boolean[] sameCol, boolean[] sameLeftDiag, boolean[] sameRightDiag) {
        if (row == n) {
            queenWaysCount++;
            displayQueen(grid, n);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isItSafeForQueenOpt(sameCol, sameLeftDiag, sameRightDiag, row, i, n)) {
                grid[row][i] = true;
                sameCol[i] = sameLeftDiag[(row - i) + (n - 1)] = sameRightDiag[(row + i)] = true;
                countWaysToPlaceNQueens(grid, row + 1, n);
                sameCol[i] = sameLeftDiag[(row - i) + (n - 1)] = sameRightDiag[(row + i)] = false;
                grid[row][i] = false;
            }
        }
    }

    private static boolean isItSafeForQueenOpt(boolean[] sameCol, boolean[] sameLeftDiag, boolean[] sameRightDiag, int row, int i, int n) {
        if (!sameCol[i]) return true;
        if (!sameLeftDiag[(row - i) + (n - 1)]) return true;
        if (!sameRightDiag[(row + i)]) return true;
        return false;
    }

    //----------------------------------------------------------------------------------------
    private static void displayKnights(boolean[][] grid, int n) {
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]) System.out.print("K" + " ");
                else System.out.print("." + " ");
            }
            System.out.println();
        }
    }

    public static boolean isItSafeForKnight2(boolean[][] grid, int r, int c, int n) {
        if ((r - 2) >= 0 && (c - 1) >= 0 && grid[r - 2][c - 1]) return false;
        if ((r - 1) >= 0 && (c - 2) >= 0 && grid[r - 1][c - 2]) return false;
        if ((r - 2) >= 0 && (c + 1) < n && grid[r - 2][c + 1]) return false;
        if ((r - 1) >= 0 && (c + 2) < n && grid[r - 1][c + 2]) return false;
        return true;
    }

    static int knightCount = 0;

    public static void nKnights(boolean[][] grid, int r, int c, int n, int count) {
        if (count == n) {
            displayKnights(grid, n);
            knightCount++;
            return;
        }
        for (int i = r; i < n; i++) {
            for (int j = (i == r) ? c : 0; j < n; j++) {//If
                if (isItSafeForKnight2(grid, i, j, n)) {
                    grid[i][j] = true;
                    nKnights(grid, i, j + 1, n, count + 1);
                    grid[i][j] = false;
                }
            }
        }
    }

    //---------------------------------------------------------------------------------
    private static void findStrings(char[][] chars, List<String> listStr) {
        boolean[][] visited = new boolean[chars.length][chars.length];
        for (int i = 0; i < listStr.size(); i++) {
            findStringsHelper(chars, listStr.get(i), 0, 0, 0, listStr.size(), visited);
        }
    }

    static int stringFound = 0;
    static List<Character> ans = new ArrayList<>();

    private static void findStringsHelper(char[][] chars, String str, int r, int c, int index, int n, boolean[][] visited) {
        if (index == str.length()) {
            System.out.println(ans);
            displayString(chars, visited, n);
            ans.clear();
            for (int o = 0; o < n; o++) {
                for (int p = 0; p < n; p++) {
                    visited[o][p] = true;
                }
            }
            return;
        }
        int[] x = {-1, 1, 0, 0, -1, 1, 1, -1};
        int[] y = {0, 0, -1, 1, -1, 1, -1, 1};
        for (int i = r; i < n; i++) {
            for (int j = (i == r) ? c : 0; j < n; j++) {
                if (chars[i][j] == str.charAt(index)) {
                    ans.add(chars[i][j]);
                    visited[i][j] = true;
                    for (int k = 0; k < 8; k++) {
                        if (isItSafeForString(visited, i + x[k], j + y[k], n, chars, str, index + 1)) {
                            findStringsHelper(chars, str, i + x[k], j + y[k], index + 1, n, visited);
                        }
                    }
                    ans.remove(ans.size() - 1);
                    visited[i][j] = false;
                    //todo
                }
            }
        }
    }

    private static boolean isItSafeForString(boolean[][] visited, int row, int col, int size, char[][] chars, String str, int index) {
        return row >= 0 && col >= 0 && row < size && col < size && !visited[row][col] && chars[row][col] == str.charAt(index == str.length() ? index - 1 : index);
    }

    private static void displayString(char[][] chars, boolean[][] visited, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) System.out.print(chars[i][j] + " ");
                else System.out.print("." + " ");
            }
            System.out.println();
        }
    }

    //------------------------------------------------------------------------------
    public static void main(String[] args) {
        char[][] chars = new char[][]{{'G', 'I', 'Z'},
                {'U', 'E', 'K'},
                {'Q', 'S', 'E'}};
        List<String> listStr = new ArrayList<>();
        listStr.add("geeks");
        listStr.add("for");
        listStr.add("quiz");
        listStr.add("go");
        findStrings(chars, listStr);

        /*int n = 3;
        int[][] grid = new int[n][n];
        nKnights(visited, 0, 0, n, 0);
        System.out.println(knightCount);
*/
        /*Given an n*n board, with a knight placed at 0,0.
        Check/print if the knight can cover all the cells of the board using its usual
        chess moves without visiting any cell twice.*/
        //knightsWays(chessGrid, n, 0, 0, 0,visited);

        /*boolean[][] grid = new boolean[n][n];
        boolean[] sameCol = new boolean[n];
        boolean[] sameLeftDiag = new boolean[n + (n - 1)];
        boolean[] sameRightDiag = new boolean[n + (n - 1)];*/
        //countWaysToPlaceNQueens(grid, 0, n);
        //countWaysToPlaceNQueensOpt(grid, 0, n, sameCol, sameLeftDiag, sameRightDiag);
        //System.out.println(queenWaysCount);

        /*int[] arr = new int[]{1,2,3};
        List<Integer> temp = new ArrayList<>();
        subsetBackTrack(arr, 0, arr.length,temp);*/
        //permutation("ABC", 0);

        //Rat in a maze
        /*int [][] arr = new int[][]{{1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}};
        System.out.println(findTotalPaths(arr));*/
    }
}
