package BackTracking.DynamicProg;

import java.util.Arrays;

/**
 * Find minimum number of coins that make a given value
 * Eg:
 * Input: coins[] = {25, 10, 5}, V = 30
 * Output: Minimum 2 coins required
 * We can use one coin of 25 cents and one of 5 cents
 */
public class MinimizingCoins {
    private static void minCoins(int[] coins, int k, int[] ans, int ansIndex) {
        if (Arrays.stream(ans).sum() == k) {
            System.out.println(Arrays.toString(ans));
            return;
        }
        if (ansIndex >= ans.length) return;
        for (int i = 0; i < coins.length; i++) {
            if (ans[ansIndex - 1 < 0 ? 0 : ansIndex - 1] <= coins[i]) {
                ans[ansIndex] = coins[i];
                minCoins(coins, k, ans, ansIndex + 1);
                ans[ansIndex] = 0;
            }
        }
    }

    //todo
    private static int minCoinTD(int[] coins, int n, int sum, int[] dp) {
        if (sum < 0)
            return Integer.MAX_VALUE;
        if (sum == 0)
            return 0;
        if (dp[sum] != -1)
            return dp[n];
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int recResult = minCoinTD(coins, n, sum - coins[i], dp);
            if (recResult == Integer.MAX_VALUE)
                continue;
            result = Math.min(result, 1+recResult);
        }
        dp[sum] = result;
        return dp[sum];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,5,3,6};
        int sum = 10;
        int[] dp = new int[sum+1];
        Arrays.fill(dp, -1);
        System.out.println(minCoinTD(arr, arr.length, sum, dp));
        //minCoins(new int[]{1, 5, 7}, 8, new int[4], 0);
    }
}
