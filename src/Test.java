import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class Test{
    public static void main(String[] args) {
        noOfTriplets(new int[]{1,2,3}, 6);
        String s = "helle";
        char[] charArr =s.toCharArray();
        StringBuilder sb = new StringBuilder("jjj");
        System.out.println(charArr[0]);

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