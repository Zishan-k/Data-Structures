package sorting;
import java.util.Arrays;

public class BubbleSort{

    public static void main(String args[]) {
        bubbleSort(new int[] { 20, 12, 45, 19, 91, 55 });
    }

    public static void bubbleSort(int[] numbers) {
        System.out.printf("Unsorted array :%s %n", Arrays.toString(numbers));

        for (int i = 0; i < numbers.length; i++) {
            for (int j = numbers.length -1; j > i; j--) {
                if (numbers[j] < numbers[j - 1]) {
                    int temp = numbers[j-1];
                    numbers[j-1] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }

        System.out.printf( Arrays.toString(numbers));
    }

   /* public static void swap(int[] array, int From, int to){
        int temp = array[From];
        array[From] = array[to];
        array[to] = temp;
    }
*/
}