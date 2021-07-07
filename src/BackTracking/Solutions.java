package BackTracking;

public class Solutions {
    public static void main(String[] args) {
        System.out.println(checkMissing(new int[]{1,2,3,4,5,6,8,9}));
    }

    private static int checkMissing(int[] arr) {
        int actualSum = 0;
        int curSum = 0;
        for (int i = 0; i < arr.length; i++) {
            actualSum = (arr[i] * (arr[i]+1))/2;
            curSum += arr[i];
            if(actualSum != curSum) return actualSum-curSum;
        }
        return -1;
    }

}

