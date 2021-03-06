package Hashing;

import java.util.HashMap;
import java.util.Map;

public class Hashing {
    //1, 2, 3, 2, 3, 1, 3
    public static int findNumberOccurringOddTimesIn(int[] arr){
        Map<Integer, Integer> valueVsCount = new HashMap<>();
        for (int j = 0 ; j <= arr.length; j++) {
            if (!valueVsCount.containsKey(arr[j])) {
                valueVsCount.put(arr[j], 1);
            } else {
                if(valueVsCount.get(arr[j]) % 2 == 0){
                    valueVsCount.put(arr[j], valueVsCount.get(arr[j]) + 1);
                }
            }

        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(findNumberOccurringOddTimesIn(new int[]{1, 2, 3, 2, 3, 1, 3}));
    }
}
