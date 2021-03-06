package Search;

public class BinarySearch {
    int searchUsingBinary(int[] arr, int d) {
        int first = 0;
        int last = arr.length;
        int mid = (first + last) / 2;

        while (arr[mid] != d) {
            if (d > arr[mid]) {
                first = mid + 1;
            } else {
                last = mid - 1;
            }
            mid = (first + last) / 2;
        }
        return mid;
    }

    /**
     * 0, 0, 0, 0, 0, 0, 1, 1, 1, 1
     * */
    public static int findFirstOne(int[] arr) {
        int first = 0, last = arr.length, middle = (first + last) / 2;

        while (true) {
            if (arr[middle] != 1) {
                first = middle + 1;
            } else if (arr[middle] == 1 && arr[middle - 1] == 0) {
                return middle;
            } else if (arr[middle] == 1 && arr[middle - 1] == 1) {
                last = middle - 1;
            }
            middle = (first + last) / 2;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 0, 0, 1, 1, 1, 1};
        System.out.println(findFirstOne(arr));
    }
}