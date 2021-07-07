package BackTracking.DynamicProg;

/**
 * Given x, find minimum no of operations to reduce x to 1 using:
 * 1. Subtract 1
 * 2. divide by 2
 * 3. divide by 3
 */
public class ReduceNToOne {
    private static int reduceTD(int n, int[] dp) {
        if (n == 2 || n == 3) return 1;
        if (n == 1) return 0;
        if (n < 1)
            return Integer.MAX_VALUE;//If we reach -1, then it will take infinite steps to reach 1 i.e. we'll never reach

        if (dp[n] != 0) return dp[n];
        int subByOne = Integer.MAX_VALUE, divByTwo = Integer.MAX_VALUE, divByThree = Integer.MAX_VALUE;
        if (n % 3 == 0)
            divByThree = 1 + reduceTD(n / 3, dp);
        if (n % 2 == 0)
            divByTwo = 1 + reduceTD(n / 2, dp);
        subByOne = 1 + reduceTD(n - 1, dp);
        dp[n] = Math.min(subByOne, Math.min(divByTwo, divByThree));
        return dp[n];
    }

    private static int reduceBU(int n) {
        int[] dp = new int[n + 1];
        dp[0] = Integer.MAX_VALUE;
        dp[1] = 0;
        dp[2] = dp[3] = 1;
        int subByOne = Integer.MAX_VALUE, divByTwo = Integer.MAX_VALUE, divByThree = Integer.MAX_VALUE;
        for (int i = 4; i <= n; i++) {
            if (i % 3 == 0) {
                divByThree = 1 + dp[i / 3];
            }
            if (i % 2 == 0) {
                divByThree = 1 + dp[i / 2];
            }
            subByOne = 1 + dp[i - 1];
            dp[i] = Math.min(subByOne, Math.min(divByTwo, divByThree));
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 14;
        System.out.println(reduceTD(n, new int[n + 1]));
        System.out.println(reduceBU(n));

    }

}
