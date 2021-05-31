package arrays;


import java.util.HashSet;

/*
Input: k = 3, arr[] = {1, 2, 3, 4, 1, 2, 3, 4}
Output: false
All duplicates are more than k distance away.

Input: k = 3, arr[] = {1, 2, 3, 1, 4, 5}
Output: true
1 is repeated at distance 3.

Input: k = 3, arr[] = {1, 2, 3, 4, 5}
Output: false

Input: k = 3, arr[] = {1, 2, 3, 4, 4}
Output: true
*/
public class DuplicateWithinKDistance {
    public static void main(String[] args) {
        System.out.println(isDuplicatePresent(new int[]{1, 2, 3, 1, 4, 5}, 3));
    }

    private static boolean isDuplicatePresent(int[] arr, int k) {
        HashSet<Integer> hashSet = new HashSet<>();
        int count = 0;
        for(int i = 0; i < arr.length - 1; i++){
            if (count < k) {
                if (hashSet.contains(arr[i])) return true;
                hashSet.add(arr[i + 1]);
                count++;
            } else {
                hashSet.clear();
                hashSet.add(arr[i]);
                count = 0;
            }
        }
        return false;
    }
}
