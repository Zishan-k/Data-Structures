import java.util.*;

public class Test{
    public static void main(String[] args) {
        char c = '9';
        System.out.println(c - '0');
    }

    public static boolean countPairs(int[] A){
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            if(hashMap.containsKey(A[i]))
            hashMap.put(A[i], hashMap.get(A[i]) + 1);
            else
                hashMap.put(A[i], 1);
        }

        for (Map.Entry<Integer, Integer> entry :
                hashMap.entrySet()) {
            if (entry.getValue() != 2)
                return false;
        }
        return true;
    }

    String firstAlphabet(String S) {
        char[] cArr =S.toCharArray();
        String result = String.valueOf(cArr[0]);
        for(int i = 0; i < cArr.length; i++){
            if(cArr[i] == ' ')
                result = result.concat(String.valueOf(cArr[i + 1]));
        }
        return result;
    }


    //[1,2,3,4,5]
    private static void noOfTriplets(int[] arr, int d) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length - 1; j++) {
               if((arr[i] + arr[j] + arr[j+1]) == d)
                   count++;
            }
        }
        System.out.println(count);
    }
}