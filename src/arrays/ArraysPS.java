package arrays;

public class ArraysPS { //PS= Problem Solving
    void rotateArray(int[] arr, int d){
        int temp;
        for(int i=0; i<d ;i++){
            temp = arr[0];
            for(int j=0; j<arr.length-1 ;j++){
                arr[j] = arr[j+1];
            }
            arr[arr.length-1] = temp;
        }
        for (int a: arr) {
            System.out.print(a + " ");
        }
    }
    void rotationCount(int[] arr){

    }

    public static void main(String[] args) {
        ArraysPS aps= new ArraysPS();
        int[] arr= new int[]{1,2,3,4,5,6};
        aps.rotateArray(arr, 3);
    }
}
