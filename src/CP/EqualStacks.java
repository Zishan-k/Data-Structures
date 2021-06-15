package CP;

import java.util.ArrayList;
import java.util.List;

public class EqualStacks {
    private static int sumOf(List<Integer> h1){
        if(h1.isEmpty()) return -1;
        int sum = 0;
        for (int i :
                h1) {
            sum += i;
        }
        return sum;
    }
    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // Write your code here
        int minSum = 9999;
        while(sumOf(h1) != sumOf(h2) || sumOf(h2) != sumOf(h3)){
            int sh1 = sumOf(h1), sh2 = sumOf(h2), sh3 = sumOf(h3);
            if (sh1 < minSum) minSum = sh1;
            if (sh2 < minSum) minSum = sh2;
            if (sh3 < minSum) minSum = sh3;
            while(sumOf(h1) > minSum) h1.remove(0);
            while(sumOf(h2) > minSum) h2.remove(0);
            while(sumOf(h3) > minSum) h3.remove(0);
        }
        return minSum;
    }

    public static void main(String[] args) {
        List<Integer> h1 = new ArrayList<>();
        List<Integer> h3 = new ArrayList<>();
        List<Integer> h2 = new ArrayList<>();
        h1.add(3);
        h1.add(2);
        h1.add(1);
        h1.add(1);
        h1.add(1);

        h2.add(4);
        h2.add(3);
        h2.add(2);

        h3.add(1);
        h3.add(1);
        h3.add(4);
        h3.add(1);

        System.out.println(equalStacks(h1,h2,h3));
    }
}
