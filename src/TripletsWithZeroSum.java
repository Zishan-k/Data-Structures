public class TripletsWithZeroSum {
    public static void main(String[] args) {

        int[] arr = new int[]{0, -1, 2, -3, 1};
        int n= arr.length;

        for (int i = 0; i < n-2; i++) {
            for (int j = i; j < n-1; j++) {
                for (int k = 0; k < n; k++) {
                    if((arr[i] + arr[j] + arr[k]) == 0) {
                        System.out.println(" "+"("+arr[i] + arr[j] + arr[k]+")"+" ");
                    }
                }
            }
        }
    }
}


