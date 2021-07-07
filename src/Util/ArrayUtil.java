package Util;

public class ArrayUtil {
    public static int max(int[] arr) {
        int maxVal = Integer.MIN_VALUE;
        for (int i : arr) if (maxVal < i) maxVal = i;
        return maxVal;
    }
}
