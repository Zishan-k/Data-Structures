package sorting;

import org.jetbrains.annotations.NotNull;

public class Sort {

    void selectionSort(int[] arr){
        int min, temp=0;
        min= arr[0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length ; j++) {
                if(arr[i] > arr[j]){
                    temp= arr[i];
                    arr[i]= arr[j];
                    arr[j]= temp;
                }
            }
        }
        for (int val:
             arr) {
            System.out.print(" "+ val);
        };
    }

    void bubbleSort(int @NotNull [] arr){
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j] > arr[j+1]){
                    temp= arr[j];
                    arr[j]= arr[j+1];
                    arr[j+1]= temp;
                }
            }
        }
        for (int val:
                arr) {
            System.out.print(" "+ val);
        };
    }

    void mergeSort(int[] arr){

    }

    public static void main(String[] args) {
        Sort sort= new Sort();
        sort.bubbleSort(new int[]{2,3,1,5,4});
    }
}
