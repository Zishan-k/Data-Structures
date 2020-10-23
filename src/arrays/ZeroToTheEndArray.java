package arrays;

public class ZeroToTheEndArray {
    private void moveZerosToTheEnd(int[] arr) {
        int temp, i, j;
        for (i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                temp = arr[i];
                for (j = i; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[j] = temp;
                if(arr[i] == 0){
                    i--;
                }
            }
        }
    }

    private void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(" " + val);
        }
    }

    public static void main(String[] args) {
        ZeroToTheEndArray obj = new ZeroToTheEndArray();
        int[] arr = new int[]{1, 2, 0, 0, 0, 3, 0, 0, 4};
        obj.moveZerosToTheEnd(arr);
        obj.printArray(arr);
    }
}