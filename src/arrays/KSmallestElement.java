package arrays;

public class KSmallestElement {
    void kthSmallestElement(int[] arr, int k){
        int temp;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for (int view:
             arr) {
            System.out.print(view + " ");
        }
    }

    public static void main(String[] args) {
        KSmallestElement obj= new KSmallestElement();
        int a[]= new int[]{10,2,4,2,5,6,99};
        obj.kthSmallestElement(a, 3);
    }
}
