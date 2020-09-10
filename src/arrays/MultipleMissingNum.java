package arrays;

public class MultipleMissingNum {
    public static void main(String[] args) {
        int arr[] = {1, 2, 2, 2, 3, 4, 5, 7, 8, 9, 9};
        int arr2[] = new int[arr.length];

        for (int i : arr) {
            arr2[i] = 1;
        }
        System.out.println("Missing Numbers");
        for (int i = 1; i < arr2.length; i++) {
            if (arr2[i] == 0) {
                System.out.print(i + " ");
            }
        }
    }
}

