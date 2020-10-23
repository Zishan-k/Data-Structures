package Temp;

import java.util.*;

public class PrimeFactorVisitation {
    public void lightBulbs(int[] states, ArrayList<Integer> numbers){
        for (int i = 0; i < numbers.size(); i++) {
            List<Integer> primeFactor = primeFactors(numbers.get(i));
            for (int j = 0; j < primeFactor.size(); j++) {
                int interval = primeFactor.get(j);
                int k=interval;
                while(k < states.length) {
                    if(states[interval] == 0)
                        states[interval] = 1;
                    else
                        states[interval] = 0;
                    k = k + interval;
                }
            }
        }
        System.out.println(Arrays.toString(states));
    }

    public static List<Integer> primeFactors(int number) {
        int n = number;
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        return factors;
    }

    public static void main(String[] args) {
        PrimeFactorVisitation primeFactorVisitation = new PrimeFactorVisitation();
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(15);
        primeFactorVisitation.lightBulbs(new int[]{1, 1, 0, 0, 1, 1, 0, 1, 1, 1}, arrayList);
    }
}
