package Hashing;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Hashing {
    //1, 2, 3, 2, 3, 1, 3
    public static int findNumberOccurringOddTimesIn(int[] arr){
        Map<Integer, Integer> valueVsCount = new HashMap<>();
        for (int i : arr) {
            valueVsCount.put(i, (valueVsCount.containsKey(i) ? (valueVsCount.get(i) + 1) : 1));
        }
        for (Map.Entry<Integer, Integer> entry : valueVsCount.entrySet()) {
            if (entry.getValue() % 2 == 1)
                return entry.getKey();
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(findNumberOccurringOddTimesIn(new int[]{1, 2, 3, 2, 3, 1, 3}));
    }
}
