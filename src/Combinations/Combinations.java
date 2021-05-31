package Combinations;

import java.util.Arrays;

public class Combinations {
    public static void main(String[] args) {
        int[] arr = {10, 2, 3, 4, 5, 9, 7, 8};
        combinations2(arr, 4, 0, new int[4], 23);
    }
    static void combinations2(int[] arr, int len, int startPosition, int[] result, int x) {
        if (Arrays.stream(result).sum() == x) {
            System.out.println(Arrays.toString(result));
            return;
        }
        for (int i = startPosition; i <= arr.length - len; i++) {
            result[result.length - len] = arr[i];
            combinations2(arr, len - 1, i + 1, result, x);
        }
    }
}
//1 2 4 5
//n*n-1/2

