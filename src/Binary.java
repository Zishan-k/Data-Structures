public class Binary {
    static int searchUsingBinary(int[] arr, int element){
        int l = 0, r = arr.length - 1, m = (l+r)/2;
        while(l < r){
            if(element > arr[m]){
                l = m+1;
            } else{
                r = m-1;
            }
            m = (l+r)/2;
            if(arr[m] == element)
                return m;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(Binary.searchUsingBinary(new int[]{11,22,44,55,66,77}, 77));
    }
}
