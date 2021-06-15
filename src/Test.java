import java.util.*;

public class Test{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int count = 0;
        while (n-- > 0) {
            int x = s.nextInt();
            if (x % k == 0)
                count++;
        }
        System.out.println(count);
    }

    static String getBinary(Integer i){
        if(i == 1) return i.toString();
        StringBuilder str = new StringBuilder();
        while(i > 0){
            Integer temp = i % 2;
            i = i / 2;
            str.append(temp);
        }
        return str.toString();
    }

    static String reverseOf(String str){
        char[] cArr = str.toCharArray();
        for(int i = 0, j = str.length() - 1; i != j; i++, j--){
            char temp = cArr[i];
            cArr[i] = cArr[j];
            cArr[j] = temp;
        }
        return Arrays.toString(cArr);
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