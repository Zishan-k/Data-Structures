public class RotateArray {
    void rotateArray(int[] arr, int d){
        //1,2,3,4,5,6,7
        int temp,j;
        for(int i = 0; i < d; i++){
            temp = arr[0];
            for (j = 0; j < arr.length-1; j++) {
                arr[j] = arr[j+1];
            }
            arr[j] = temp;
            for(int element : arr){
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        RotateArray r=new RotateArray();
        r.rotateArray(arr, 3);
    }
}
