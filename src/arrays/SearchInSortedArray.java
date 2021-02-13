package arrays;

public class SearchInSortedArray {
    int findPivot(int[] rotatedArr){
        for (int i = 0; i < rotatedArr.length; i++) {
            if(rotatedArr[i] < rotatedArr[i+1]){
                continue;
            }else {
                return i;
            }
        }
    return -1;
    }

    public static void main(String[] args) {
        SearchInSortedArray searchInSortedArray = new SearchInSortedArray();
        int[] array = new int[]{3,4,5,1,2};
        System.out.println(searchInSortedArray.findPivot(array));
    }
}
