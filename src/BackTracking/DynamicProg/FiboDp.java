package BackTracking.DynamicProg;

import java.util.Arrays;

public class FiboDp {
    private static int fiboDpTD(int n, int[] arr) {
        if (n == 0 || n == 1) return n;
        if (arr[n] != -1) return arr[n];
        arr[n] = fiboDpTD(n - 1, arr) + fiboDpTD(n - 2, arr);
        return arr[n];
    }

    private static int fiboDpBU(int n, int[] dp) {
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int n = 6;
        int[] arr = new int[n + 1];
        Arrays.fill(arr, -1);
        System.out.println(fiboDpTD(n, arr));
    }
}
