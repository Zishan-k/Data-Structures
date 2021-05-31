public class MissingNumber {
    //1,2,,5,6,7
    public static int getMissingNumber(int[] arr) {
        int actualSum = 0, currentSum = 0;
        for (int j : arr) {
            actualSum = actualSum + j;
            currentSum = j * (j + 1) / 2;
            if (actualSum != currentSum) return currentSum - actualSum;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(getMissingNumber(new int[]{1, 2, 3, 5, 6, 7}));
    }
}
