package Search;

public class BinarySearch {
    int searchUsingBinary(int[] arr, int d){
        int first = 0;
        int last = arr.length;
        int mid = (first + last)/2;

        while(arr[mid] != d){
            if(d > arr[mid]){
                first = mid + 1;
            }else {
                last = mid - 1;
            }
            mid = (first + last)/2;
        }
        return mid;
    }

    public static void main(String[] args) {
        System.out.println(
                new BinarySearch().searchUsingBinary(new int[]{21,22,33,45,67,89,91,99,108,182,382}, 108)
        );
    }
}