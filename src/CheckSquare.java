public class CheckSquare {
    static boolean checkIfSquare(int[] arr1, int[] arr2, int[] arr3, int[] arr4){
        return (arr2[0] - arr1[0]) == (arr3[0] - arr4[0]) && (arr3[1] - arr2[1]) == (arr4[1] - arr1[1]);
    }

    public static void main(String[] args) {
        System.out.println(checkIfSquare(new int[]{-4,4}, new int[]{-1,-1}, new int[]{4,2}, new int[]{1,7}));
    }
}
