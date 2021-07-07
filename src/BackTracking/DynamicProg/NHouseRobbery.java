package BackTracking.DynamicProg;

import java.util.Arrays;

/**
 * Given N houses with money in them, find the maximum sum of money a robber can steal from non adjacent houses.
 * [6, 2, 4, 9]
 * sol: 2 options: If an element is included or not included
 */
public class NHouseRobbery {
    private static int lootHouseTD(int[] houses, int i, int[] dp) {
        if (i == 0)
            return dp[0] = houses[0];
        if (i == 1)
            return dp[i] = Math.max(houses[0], houses[1]);
        if (dp[i] != -1) return dp[i];
        dp[i] = Math.max((lootHouseTD(houses, i - 2, dp) + houses[i]), lootHouseTD(houses, i - 1, dp));
        return dp[i];
    }

    private static int lootHouseBU(int[] houses, int[] dp) {
        dp[0] = houses[0];
        dp[1] = Math.max(houses[0], houses[1]);
        for (int i = 2; i < houses.length; i++) {
            dp[i] = Math.max(dp[i - 2] + houses[i], dp[i - 1]);
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        int[] dp = new int[4];
        Arrays.fill(dp, -1);
        System.out.println(lootHouseTD(new int[]{6, 2, 4, 9}, 3, dp));
        System.out.println(lootHouseBU(new int[]{6, 2, 4, 9}, dp));
    }
}
