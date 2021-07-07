package BackTracking.DynamicProg;

import Util.ArrayUtil;
import java.util.Arrays;

/**
 * The length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 */
public class LongestIncreasingSubseq {
    private static int lisTD(int[] arr, int n, int[] dp){
        if(n == 1) return 1;
        if(dp[n] != 0) return dp[n];
        for (int j = n-1; j >= 0; j--) {
            if(arr[n] > arr[j])
                dp[n] = Integer.max(dp[n], 1 +lisTD(arr, n-1, dp));
            else dp[n] = 1;
        }
        return ArrayUtil.max(dp);
    }

    private static int lisBU(int[] arr, int n){
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j])
                    dp[i] = Math.max(dp[i], 1+dp[j]);
            }
        }
        return ArrayUtil.max(dp);
    }

    public static void main(String[] args) {
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        //int[] dp = new int[arr.length];
        //Arrays.fill(dp, 0);
        System.out.println(lisBU(arr, arr.length));
    }
}
