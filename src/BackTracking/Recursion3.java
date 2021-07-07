package BackTracking;

import java.util.HashSet;
import java.util.Set;

public class Recursion3 {
    public static void main(String[] args) {
        /*You are given a 2D matrix of dim m*n. You will start from top left cell and you want to go to bottom right.
         * At each point you can move either right or down. Print and count all possible paths.*/
        //findPaths(0, 0, 3, 3, "");
        //System.out.println("Total paths:" + totalPaths);

        /*There are n cells arranged in linear fashion. You have a dice with 6 faces(123456).
        You are standing at the 0th cell and want to reach (n-1)th cell.
        At each cell you can have 6 possible jumps to make.
        In how many ways you can reach to (n-1)th cell and print it.*/
        //dicePath(6, 0, "");


        /*Given n, print first n+1 whole numbers in lexicographical order.*/
        //printInLexicoOrder(1000, 0);

        /*Given a string, with all unique characters, print all possible permutations of strings.*/
        //permutations("ABC", "");
        spacePermutation("ABC", "", 0);

    }

    private static void permutations(String str, String perms) {
        if (str.isEmpty()) {
            System.out.println(perms);
            return;
        }
        Set<Character> s = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            char firstChar = str.charAt(i);
            if (!s.contains(firstChar)) {
                String restString = str.substring(0, i) + str.substring(i + 1);
                s.add(firstChar);
                permutations(restString, perms + firstChar);
            }
        }
    }

    private static void spacePermutation(String str, String ans, int i) {
        if (i >= str.length()) {
            System.out.println(ans);
            return;
        }
        spacePermutation(str, ans + str.charAt(i), i + 1);
        if(i != str.length()-1)
        spacePermutation(str, ans + str.charAt(i) + " ", i + 1);
    }

    //Recursive part 3 pdf
    private static void printInLexicoOrder(int n, int i) {
        if (i > n) return;
        System.out.println(i);
        for (int j = (i == 0) ? 1 : 0; j <= 9; j++) {
            printInLexicoOrder(n, 10 * i + j);
        }
    }

    private static void dicePath(int n, int i, String osf) {
        if (i == (n - 1)) {
            System.out.println(osf);
            return;
        }
        if (i >= n) return;

        dicePath(n, i + 1, osf + 1);
        dicePath(n, i + 2, osf + 2);
        dicePath(n, i + 3, osf + 3);
        dicePath(n, i + 4, osf + 4);
        dicePath(n, i + 5, osf + 5);
        dicePath(n, i + 6, osf + 6);
    }

    static int totalPaths = 0;

    private static void findPaths(int i, int j, int n, int m, String osf) {
        if (i == n - 1 && j == m - 1) {
            System.out.println(osf);
            totalPaths++;
        }

        if (i >= n || j >= n) return;
        findPaths(i, j + 1, n, m, osf + "R");
        findPaths(i + 1, j, n, m, osf + "D");
        findPaths(i + 1, j + 1, n, m, osf + "->");
    }
}
